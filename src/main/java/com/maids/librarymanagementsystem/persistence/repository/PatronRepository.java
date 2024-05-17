package com.maids.librarymanagementsystem.persistence.repository;


import com.maids.librarymanagementsystem.persistence.entity.PatronEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatronRepository extends JpaRepository<PatronEntity, Long> {
}
