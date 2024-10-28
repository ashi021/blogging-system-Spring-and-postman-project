package com.demo.blogging_system.Entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "users") // This table stores user information in the database
public class User {

    @Id // This marks the primary key for the user
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This automatically generates the user ID
    private Long userId; // Unique ID for each user

    @Column(nullable = false) // This column cannot be null
    private String userName; // Name of the user

    @Column(nullable = false, unique = true) // This column cannot be null and must be unique
    private String userEmail; // Email of the user

    @Column(nullable = false) // This column cannot be null
    private String userPassword; // Password of the user

    // One user can have many posts
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // This sets up the relationship to posts
    private Set<Post> posts = new HashSet<>(); // Set of posts created by this user

    // Getters and Setters
    public Long getUserId() {
        return userId; // Returns the user ID
    }

    public void setUserId(Long userId) {
        this.userId = userId; // Sets the user ID
    }

    public String getUserName() {
        return userName; // Returns the name of the user
    }

    public void setUserName(String userName) {
        this.userName = userName; // Sets the name of the user
    }

    public String getUserEmail() {
        return userEmail; // Returns the user's email
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail; // Sets the user's email
    }

    public String getUserPassword() {
        return userPassword; // Returns the user's password
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword; // Sets the user's password
    }

    public Set<Post> getPosts() {
        return posts; // Returns the posts created by this user
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts; // Sets the posts for this user
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
                + userPassword + ", posts=" + posts + "]"; // Returns a string representation of the user
    }

    // Default constructor
    public User() {
        super();
    }

    // Parameterized constructor
    public User(Long userId, String userName, String userEmail, String userPassword, Set<Post> posts) {
        super();
        this.userId = userId; // Sets the user ID
        this.userName = userName; // Sets the user's name
        this.userEmail = userEmail; // Sets the user's email
        this.userPassword = userPassword; // Sets the user's password
        this.posts = posts; // Sets the user's posts
    }
}
