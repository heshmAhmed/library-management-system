package com.maids.librarymanagementsystem.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Data
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"book_id", "patron_id", "borrow_date"})
})
public class BorrowingRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private BookEntity book;

    @ManyToOne
    private PatronEntity patron;

    private Date borrowDate;

    private Date returnDate;
}
