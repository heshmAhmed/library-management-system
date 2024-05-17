package com.maids.librarymanagementsystem.controller;

import com.maids.librarymanagementsystem.dto.PatronDto;
import com.maids.librarymanagementsystem.service.patron.PatronService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library/api/patrons")
public class PatronController {
    @Autowired
    private PatronService patronService;

    @GetMapping
    public ResponseEntity<Page<PatronDto>> getAllPatrons(Pageable pageable) {
        return ResponseEntity.ok(patronService.getAllPatrons(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatronDto> getPatronById(@PathVariable Long id) {
        return new ResponseEntity<>(patronService.getPatronById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PatronDto> addPatron(@RequestBody @Valid PatronDto patron) {
        PatronDto addedPatron = patronService.addPatron(patron);
        return new ResponseEntity<>(addedPatron, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatronDto> updatePatron(@PathVariable Long id, @RequestBody @Valid PatronDto updatedPatron) {
        PatronDto patron = patronService.updatePatron(id, updatedPatron);
        return ResponseEntity.ok(patron);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatron(@PathVariable Long id) {
        patronService.deletePatron(id);
        return ResponseEntity.noContent().build();
    }
}
