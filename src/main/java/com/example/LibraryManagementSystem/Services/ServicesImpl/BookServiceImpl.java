package com.example.LibraryManagementSystem.Services.ServicesImpl;

import com.example.LibraryManagementSystem.Model.Book;
import com.example.LibraryManagementSystem.Repos.BookRepository;
import com.example.LibraryManagementSystem.Services.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;


    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public Optional<Book> getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        if (bookRepository.existsById(id)) {
            book.setId(id);
            return bookRepository.save(book);
        }
        throw new RuntimeException("Book not found with id: " + id);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}