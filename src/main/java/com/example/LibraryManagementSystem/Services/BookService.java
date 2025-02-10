package com.example.LibraryManagementSystem.Services;

import com.example.LibraryManagementSystem.Model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Optional<Book> getBookByIsbn(String isbn);
    Book addBook(Book book);
    Book updateBook(Long id, Book book);
    void deleteBook(Long id);
}