package com.demo.blogging_system.Controller;

import com.demo.blogging_system.Entities.User;
import com.demo.blogging_system.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // This class handles HTTP requests related to users
@RequestMapping("/api/users") // This sets the base URL for user-related requests
public class UserController {

    @Autowired // This automatically injects the UserService into this controller
    private UserService userService; // Service to manage users

    // Create a new user
    @PostMapping // This maps POST requests to create a new user
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user); // Calls service to create the user
        return ResponseEntity.ok(createdUser); // Returns the created user
    }

    // Update an existing user by ID
    @PutMapping("/{userId}") // This maps PUT requests to update a user by their ID
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long userId) {
        User updatedUser = userService.updateUser(user, userId); // Calls service to update the user
        return ResponseEntity.ok(updatedUser); // Returns the updated user
    }

    // Get a user by their ID
    @GetMapping("/{userId}") // This maps GET requests to get a user by their ID
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId); // Calls service to get the user
        return ResponseEntity.ok(user); // Returns the found user
    }

    // Get a user by their email
    @GetMapping("/email/{userEmail}") // This maps GET requests to get a user by their email
    public ResponseEntity<User> getUserByEmail(@PathVariable String userEmail) {
        User user = userService.getUserByEmail(userEmail); // Calls service to get the user by email
        return ResponseEntity.ok(user); // Returns the found user
    }

    // Get all users
    @GetMapping // This maps GET requests to get all users
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers(); // Calls service to get all users
        return ResponseEntity.ok(users); // Returns the list of users
    }

    // Delete a user by ID
    @DeleteMapping("/{userId}") // This maps DELETE requests to remove a user by their ID
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId); // Calls service to delete the user
        return ResponseEntity.noContent().build(); // Returns a response with no content (204 status)
    }
}
