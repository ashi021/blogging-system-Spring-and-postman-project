package com.demo.blogging_system.Service;

import com.demo.blogging_system.Entities.Post;

import java.util.List;

// This is an interface for Post service operations
public interface PostService {
    
    // Method to create a new post for a specific user and category
    Post createPost(Post post, Long userId, Long categoryId);
    
    // Method to update an existing post by its ID
    Post updatePost(Post post, Long postId);
    
    // Method to get a specific post by its ID
    Post getPostById(Long postId);
    
    // Method to get all posts in a specific category
    List<Post> getPostsByCategory(Long categoryId);
    
    // Method to get all posts created by a specific user
    List<Post> getPostsByUser(Long userId);
    
    // Method to get a paginated list of all posts
    List<Post> getAllPosts(int page, int size); // Ensure this is present
    
    // Method to delete a post by its ID
    void deletePost(Long postId);
}
