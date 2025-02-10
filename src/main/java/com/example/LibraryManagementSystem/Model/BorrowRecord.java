package com.example.LibraryManagementSystem.Model;

import lombok.Data;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class BorrowRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;

    private LocalDate borrowDate;
    private LocalDate returnDate;

}