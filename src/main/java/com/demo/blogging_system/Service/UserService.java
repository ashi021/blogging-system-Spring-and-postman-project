package com.demo.blogging_system.Service;

import com.demo.blogging_system.Entities.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(User user, Long userId);
    User getUserById(Long userId);
    User getUserByEmail(String userEmail);
    List<User> getAllUsers();
    void deleteUser(Long userId);
}
