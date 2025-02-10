package com.example.LibraryManagementSystem.Services;

import com.example.LibraryManagementSystem.Model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    Optional<User> getUserByEmail(String email);
    User addUser(User user);
    void deleteUser(Long id);
}