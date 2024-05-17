package com.maids.librarymanagementsystem.service.book;

import com.maids.librarymanagementsystem.dto.BookDto;
import com.maids.librarymanagementsystem.persistence.entity.BookEntity;
import com.maids.librarymanagementsystem.persistence.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    public Page<BookDto> getAllBooks(Pageable pageable) {
        return this.bookRepository.findAll(pageable)
                .map(bookEntity -> modelMapper.map(bookEntity, BookDto.class));
    }

    @Override
    public BookDto getBookById(Long id) {
        BookEntity bookEntity =  bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found"));
        return modelMapper.map(bookEntity, BookDto.class);
    }

    @Override
    public BookDto addBook(BookDto book) {
        BookEntity bookEntity = modelMapper.map(book, BookEntity.class);
        bookRepository.save(bookEntity);
        book.setId(bookEntity.getId());
        return book;
    }

    @Override
    public BookDto updateBook(Long id, BookDto updatedBook) {
        updatedBook.setId(id);
        BookEntity bookEntity = modelMapper.map(updatedBook, BookEntity.class);
        bookRepository.save(bookEntity);
        return updatedBook;
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
