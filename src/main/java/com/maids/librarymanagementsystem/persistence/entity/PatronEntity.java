package com.maids.librarymanagementsystem.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@Entity
public class PatronEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String contactInformation;


    @OneToMany(mappedBy = "patron", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<BorrowingRecordEntity> patronEntities = new ArrayList<>();

}
