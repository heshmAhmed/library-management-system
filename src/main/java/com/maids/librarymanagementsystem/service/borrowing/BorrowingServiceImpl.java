package com.maids.librarymanagementsystem.service.borrowing;

import com.maids.librarymanagementsystem.dto.BorrowingRecordDto;
import com.maids.librarymanagementsystem.persistence.entity.BookEntity;
import com.maids.librarymanagementsystem.persistence.entity.BorrowingRecordEntity;
import com.maids.librarymanagementsystem.persistence.entity.PatronEntity;
import com.maids.librarymanagementsystem.persistence.repository.BookRepository;
import com.maids.librarymanagementsystem.persistence.repository.BorrowingRecordRepository;
import com.maids.librarymanagementsystem.persistence.repository.PatronRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Service
public class BorrowingServiceImpl implements BorrowingService {

    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PatronRepository patronRepository;

    @Autowired
    private ModelMapper modelMapper;

    public BorrowingRecordDto borrowBook(Long bookId, Long patronId) {
        BookEntity book = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Book not found"));
        PatronEntity patron = patronRepository.findById(patronId)
                .orElseThrow(() -> new EntityNotFoundException("Patron not found"));

        Optional<BorrowingRecordEntity> optionalBorrowingRecordEntity = borrowingRecordRepository
                .findByBookIdAndPatronIdAndReturnDateIsNull(bookId, patronId);

        if (optionalBorrowingRecordEntity.isPresent()) {
            throw new EntityExistsException("borrowing record already exists");
        }

        BorrowingRecordEntity borrowingRecordEntity = new BorrowingRecordEntity();
        borrowingRecordEntity.setBook(book);
        borrowingRecordEntity.setPatron(patron);
        borrowingRecordEntity.setBorrowDate(new Date());

        borrowingRecordEntity = borrowingRecordRepository.save(borrowingRecordEntity);
        return modelMapper.map(borrowingRecordEntity, BorrowingRecordDto.class);
    }

    @Override
    public BorrowingRecordDto returnBook(Long bookId, Long patronId) {
       BorrowingRecordEntity borrowingRecord = borrowingRecordRepository
                .findByBookIdAndPatronIdAndReturnDateIsNull(bookId, patronId)
               .orElseThrow(() -> new EntityNotFoundException("Borrowing record not found"));

        borrowingRecord.setReturnDate(new Date());
        borrowingRecordRepository.save(borrowingRecord);
        return modelMapper.map(borrowingRecord, BorrowingRecordDto.class);
    }
}
