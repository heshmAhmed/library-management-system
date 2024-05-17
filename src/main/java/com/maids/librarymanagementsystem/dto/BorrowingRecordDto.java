package com.maids.librarymanagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BorrowingRecordDto {
    private Long id;
    private BookDto book;
    private PatronDto patron;
    private LocalDate borrowDate;
    private LocalDate returnDate;
}
