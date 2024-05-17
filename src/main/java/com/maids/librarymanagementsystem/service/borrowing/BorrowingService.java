package com.maids.librarymanagementsystem.service.borrowing;

import com.maids.librarymanagementsystem.dto.BorrowingRecordDto;


public interface BorrowingService {
    BorrowingRecordDto borrowBook(Long bookId, Long patronId);

    BorrowingRecordDto returnBook(Long bookId, Long patronId);
}
