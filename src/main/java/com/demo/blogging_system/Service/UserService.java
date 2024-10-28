package com.demo.blogging_system.Service;

import com.demo.blogging_system.Entities.User;

import java.util.List;

// This is an interface for User service operations
public interface UserService {
    
    // Method to create a new user
    User createUser(User user);
    
    // Method to update an existing user by their ID
    User updateUser(User user, Long userId);
    
    // Method to get a user by their ID
    User getUserById(Long userId);
    
    // Method to get a user by their email address
    User getUserByEmail(String userEmail);
    
    // Method to get a list of all users
    List<User> getAllUsers();
    
    // Method to delete a user by their ID
    void deleteUser(Long userId);
}
