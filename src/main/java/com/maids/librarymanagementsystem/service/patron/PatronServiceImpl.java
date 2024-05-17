package com.maids.librarymanagementsystem.service.patron;

import com.maids.librarymanagementsystem.dto.PatronDto;
import com.maids.librarymanagementsystem.persistence.entity.PatronEntity;
import com.maids.librarymanagementsystem.persistence.repository.BookRepository;
import com.maids.librarymanagementsystem.persistence.repository.BorrowingRecordRepository;
import com.maids.librarymanagementsystem.persistence.repository.PatronRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatronServiceImpl implements PatronService {
    @Autowired
    private PatronRepository patronRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;


    @Override
    public Page<PatronDto> getAllPatrons(Pageable pageable) {
        return patronRepository.findAll(pageable).map(patron -> modelMapper.map(patron, PatronDto.class));
    }

    @Override
    public PatronDto getPatronById(Long id) {
        PatronEntity patronEntity = patronRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patorn not found"));

        return modelMapper.map(patronEntity, PatronDto.class);
    }

    @Override
    public PatronDto addPatron(PatronDto patron) {
        PatronEntity patronEntity = patronRepository.save(modelMapper.map(patron, PatronEntity.class));
        patron.setId(patronEntity.getId());
        return patron;
    }

    @Override
    public PatronDto updatePatron(Long id, PatronDto updatedPatron) {
        updatedPatron.setId(id);
        patronRepository.save(modelMapper.map(updatedPatron, PatronEntity.class));
        return updatedPatron;
    }

    @Transactional
    @Override
    public void deletePatron(Long id) {
        patronRepository.deleteById(id);
    }
}
