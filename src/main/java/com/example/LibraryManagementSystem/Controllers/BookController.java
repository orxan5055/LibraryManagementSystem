package com.example.LibraryManagementSystem.Controllers;

import com.example.LibraryManagementSystem.Model.Book;
import com.example.LibraryManagementSystem.Services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Show all books
    @GetMapping
    public String listBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books/list";
    }

    // Show book creation form
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new Book());
        return "books/create";
    }

    // Process new book creation
    @PostMapping
    public String createBook(@ModelAttribute Book book) {
        bookService.addBook(book);
        return "redirect:/books";
    }

    // Show edit book form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "books/edit";
    }

    // Process book update
    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute Book book) {
        bookService.updateBook(id, book);
        return "redirect:/books";
    }

    // Delete book
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}