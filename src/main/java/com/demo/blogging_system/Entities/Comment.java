package com.demo.blogging_system.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "comments") // This is the table for comments in the database
public class Comment {

    @Id // This marks the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This automatically generates the comment ID
    private Long commentId; // Unique ID for each comment

    @Column(nullable = false) // This column cannot be null
    private String commentContent; // Content of the comment

    // Many comments belong to one post
    @ManyToOne(fetch = FetchType.LAZY) // Lazy loading to avoid loading all comments at once
    @JoinColumn(name = "post_id", nullable = false) // Foreign key to the post
    @JsonBackReference // Prevents serialization of the post when serializing the comment
    private Post post; // The post this comment belongs to

    @ManyToOne(fetch = FetchType.LAZY) // Many comments can be made by one user
    @JoinColumn(name = "user_id") // Foreign key to the user
    @JsonIgnore // Prevents serialization if the user is null
    private User user; // The user who made the comment

    // Getters and Setters
    public Long getCommentId() {
        return commentId; // Returns the comment ID
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId; // Sets the comment ID
    }

    public String getCommentContent() {
        return commentContent; // Returns the content of the comment
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent; // Sets the content of the comment
    }

    public Post getPost() {
        return post; // Returns the post this comment belongs to
    }

    public void setPost(Post post) {
        this.post = post; // Sets the post for this comment
    }

    public User getUser() { // Gets the user who made the comment
        return user; // Returns the user
    }

    public void setUser(User user) { // Sets the user for this comment
        this.user = user; // Sets the user
    }

    // Default constructor
    public Comment() {
        super(); // This is an empty constructor
    }

    // Parameterized constructor
    public Comment(Long commentId, String commentContent, Post post, User user) { // Constructor with parameters
        super();
        this.commentId = commentId; // Initializes comment ID
        this.commentContent = commentContent; // Initializes comment content
        this.post = post; // Initializes the post this comment belongs to
        this.user = user; // Initializes the user who made the comment
    }

    @Override
    public String toString() {
        return "Comment [commentId=" + commentId + ", commentContent=" + commentContent + ", post=" + post + ", user=" + user + "]"; // Returns a string representation of the comment
    }
}
