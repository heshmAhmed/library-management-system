package com.maids.librarymanagementsystem.service.book;

import com.maids.librarymanagementsystem.dto.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BookService {
    Page<BookDto> getAllBooks(Pageable pageable);

    BookDto getBookById(Long id);

    BookDto addBook(BookDto book);

    BookDto updateBook(Long id, BookDto updatedBook);

    void deleteBook(Long id);
}
