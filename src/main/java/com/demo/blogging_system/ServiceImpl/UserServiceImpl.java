package com.demo.blogging_system.ServiceImpl;

import com.demo.blogging_system.Entities.User;
import com.demo.blogging_system.Repository.UserRepository;
import com.demo.blogging_system.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository; // For accessing user data in the database

    // Create a new user and save it to the database
    @Override
    public User createUser(User user) {
        return userRepository.save(user); // Save the new user
    }

    // Update an existing user by their ID
    @Override
    public User updateUser(User user, Long userId) {
        // Find the user by their ID
        User existingUser = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found")); // Throw an error if not found

        // Update the user's details
        existingUser.setUserName(user.getUserName()); // Update username
        existingUser.setUserEmail(user.getUserEmail()); // Update email
        existingUser.setUserPassword(user.getUserPassword()); // Update password

        return userRepository.save(existingUser); // Save the updated user
    }

    // Get a user by their ID
    @Override
    public User getUserById(Long userId) {
        // Find and return the user by their ID
        return userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found")); // Throw an error if not found
    }

    // Get a user by their email
    @Override
    public User getUserByEmail(String userEmail) {
        // Find and return the user by their email
        return userRepository.findByUserEmail(userEmail)
            .orElseThrow(() -> new RuntimeException("User not found")); // Throw an error if not found
    }

    // Get a list of all users
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll(); // Return all users from the database
    }

    // Delete a user by their ID
    @Override
    public void deleteUser(Long userId) {
        // Find the user by their ID
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found")); // Throw an error if not found
        userRepository.delete(user); // Delete the found user
    }
}
