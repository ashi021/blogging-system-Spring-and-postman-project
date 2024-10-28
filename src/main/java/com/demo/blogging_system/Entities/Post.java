package com.demo.blogging_system.Entities;

import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

@Entity
@Table(name = "posts") // This is the table for posts in the database
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "postId") // Helps with serialization to avoid issues with circular references
public class Post {

    @Id // This marks the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This automatically generates the post ID
    private Long postId; // Unique ID for each post

    @Column(nullable = false) // This column cannot be null
    private String postTitle; // Title of the post

    @Column(columnDefinition = "TEXT", nullable = false) // This column can store long text and cannot be null
    private String postContent; // Content of the post

    @ManyToOne // Many posts can belong to one category
    @JoinColumn(name = "category_id", nullable = false) // Foreign key to the category
    private Category category; // The category this post belongs to

    @ManyToOne(fetch = FetchType.EAGER) // Many posts can be created by one user
    @JoinColumn(name = "user_id", nullable = false) // Foreign key to the user
    private User user; // The user who created the post

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // One post can have many comments
    private Set<Comment> comments = new HashSet<>(); // Set of comments for this post

    // Getters and Setters...
    public Long getPostId() {
        return postId; // Returns the post ID
    }

    public void setPostId(Long postId) {
        this.postId = postId; // Sets the post ID
    }

    public String getPostTitle() {
        return postTitle; // Returns the title of the post
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle; // Sets the title of the post
    }

    public String getPostContent() {
        return postContent; // Returns the content of the post
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent; // Sets the content of the post
    }

    public Category getCategory() {
        return category; // Returns the category this post belongs to
    }

    public void setCategory(Category category) {
        this.category = category; // Sets the category for this post
    }

    public User getUser() {
        return user; // Returns the user who created this post
    }

    public void setUser(User user) {
        this.user = user; // Sets the user for this post
    }

    public Set<Comment> getComments() {
        return comments; // Returns the comments for this post
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments; // Sets the comments for this post
    }

    @Override
    public String toString() {
        return "Post [postId=" + postId + ", postTitle=" + postTitle + ", postContent=" + postContent + ", category=" + category + ", user=" + user + "]"; // Returns a string representation of the post
    }
}
