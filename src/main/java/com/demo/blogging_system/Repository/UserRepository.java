package com.demo.blogging_system.Repository;


import com.demo.blogging_system.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query to find a user by their email (since email is unique)
    Optional<User> findByUserEmail(String userEmail);
}

