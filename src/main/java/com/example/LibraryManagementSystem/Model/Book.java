package com.example.LibraryManagementSystem.Model;

import lombok.Data;


import jakarta.persistence.*;


@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String isbn;

    @Enumerated(EnumType.STRING)
    private Availability availability;

    // Enum for availability status
    public enum Availability {
        AVAILABLE, BORROWED
    }
}