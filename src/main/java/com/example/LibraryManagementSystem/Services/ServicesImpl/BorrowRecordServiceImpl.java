package com.example.LibraryManagementSystem.Services.ServicesImpl;

import com.example.LibraryManagementSystem.Model.Book;
import com.example.LibraryManagementSystem.Model.BorrowRecord;
import com.example.LibraryManagementSystem.Model.User;
import com.example.LibraryManagementSystem.Repos.BookRepository;
import com.example.LibraryManagementSystem.Repos.BorrowRecordRepository;
import com.example.LibraryManagementSystem.Repos.UserRepository;
import com.example.LibraryManagementSystem.Services.BorrowRecordService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowRecordServiceImpl implements BorrowRecordService {

    private final BorrowRecordRepository borrowRecordRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public BorrowRecordServiceImpl(BorrowRecordRepository borrowRecordRepository,
                                   UserRepository userRepository,
                                   BookRepository bookRepository) {
        this.borrowRecordRepository = borrowRecordRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BorrowRecord> getAllRecords() {
        return borrowRecordRepository.findAll();
    }

    @Override
    public Optional<BorrowRecord> getRecordById(Long id) {
        return borrowRecordRepository.findById(id);
    }

    @Override
    public BorrowRecord borrowBook(Long userId, Long bookId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.getAvailability() == Book.Availability.BORROWED) {
            throw new RuntimeException("Book is already borrowed");
        }

        BorrowRecord record = new BorrowRecord();
        record.setUser(user);
        record.setBook(book);
        record.setBorrowDate(LocalDate.now());

        book.setAvailability(Book.Availability.BORROWED);
        bookRepository.save(book);
        return borrowRecordRepository.save(record);
    }

    @Override
    public void returnBook(Long recordId) {
        BorrowRecord record = borrowRecordRepository.findById(recordId)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        Book book = record.getBook();
        book.setAvailability(Book.Availability.AVAILABLE);
        bookRepository.save(book);

        record.setReturnDate(LocalDate.now());
        borrowRecordRepository.save(record);
    }
}
