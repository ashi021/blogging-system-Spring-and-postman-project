package com.demo.blogging_system.Entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "categories") // This is the table for categories in the database
public class Category {

    @Id // This marks the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This automatically generates the ID
    private Long categoryId; // Unique ID for each category

    @Column(nullable = false) // This column cannot be null
    private String categoryName; // Name of the category

    // One category can have many posts
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore // This prevents the posts from being shown when we serialize the category
    private Set<Post> posts = new HashSet<>(); // Set of posts under this category

    // Getters and Setters
    public Long getCategoryId() {
        return categoryId; // Returns the category ID
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId; // Sets the category ID
    }

    public String getCategoryName() {
        return categoryName; // Returns the category name
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName; // Sets the category name
    }

    public Set<Post> getPosts() {
        return posts; // Returns the set of posts
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts; // Sets the posts for this category
    }

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", posts=" + posts + "]"; // Returns a string representation of the category
	}

	// Constructor with parameters
	public Category(Long categoryId, String categoryName, Set<Post> posts) {
		super();
		this.categoryId = categoryId; // Initializes category ID
		this.categoryName = categoryName; // Initializes category name
		this.posts = posts; // Initializes the posts set
	}

	// Default constructor
	public Category() {
		super();
		// This is an empty constructor
	}
}
