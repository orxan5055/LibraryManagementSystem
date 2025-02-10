package com.example.LibraryManagementSystem.Services;

import com.example.LibraryManagementSystem.Model.BorrowRecord;

import java.util.List;
import java.util.Optional;

public interface BorrowRecordService {
    List<BorrowRecord> getAllRecords();
    Optional<BorrowRecord> getRecordById(Long id);
    BorrowRecord borrowBook(Long userId, Long bookId);
    void returnBook(Long recordId);
}