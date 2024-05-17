package com.maids.librarymanagementsystem.service.patron;

import com.maids.librarymanagementsystem.dto.PatronDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface PatronService {
    Page<PatronDto> getAllPatrons(Pageable pageable);

    PatronDto getPatronById(Long id);

    PatronDto addPatron(PatronDto patron);

    PatronDto updatePatron(Long id, PatronDto updatedPatron);

    void deletePatron(Long id);
}
