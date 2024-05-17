package com.maids.librarymanagementsystem.dto;

import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private int status;
    private String error;
    private String message;
    private String timestamp;
}
