package com.example.LibraryManagementSystem.Model;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String role; // e.g., "admin", "student"

}