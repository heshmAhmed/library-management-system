package com.maids.librarymanagementsystem.persistence.repository;

import com.maids.librarymanagementsystem.persistence.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
