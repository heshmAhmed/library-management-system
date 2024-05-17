package com.maids.librarymanagementsystem.persistence.repository;

import com.maids.librarymanagementsystem.persistence.entity.BorrowingRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecordEntity, Long> {

    Optional<BorrowingRecordEntity> findByBookIdAndPatronIdAndReturnDateIsNull(Long bookId, Long patronId);
}
