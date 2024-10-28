package com.demo.blogging_system.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.demo.blogging_system.Entities.Post;
import com.demo.blogging_system.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController // This class handles HTTP requests related to posts
@RequestMapping("/api/posts") // This sets the base URL for post-related requests
public class PostController {

    @Autowired // This automatically injects the PostService into this controller
    private PostService postService; // Service to manage posts

    // Create a new post for a specific user in a specific category
    @PostMapping("/user/{userId}/category/{categoryId}") // This maps POST requests to create a post with user and category IDs
    public ResponseEntity<Post> createPost(@RequestBody Post post, 
                                           @PathVariable Long userId, 
                                           @PathVariable Long categoryId) {
        Post createdPost = postService.createPost(post, userId, categoryId); // Calls service to create a post
        return ResponseEntity.ok(createdPost); // Returns the created post
    }

    // Update an existing post by ID
    @PutMapping("/{postId}") // This maps PUT requests to update a post by its ID
    public ResponseEntity<Post> updatePost(@RequestBody Post post, @PathVariable Long postId) {
        Post updatedPost = postService.updatePost(post, postId); // Calls service to update the post
        return ResponseEntity.ok(updatedPost); // Returns the updated post
    }

    // Get a specific post by ID
    @GetMapping("/{postId}") // This maps GET requests to get a post by its ID
    public ResponseEntity<Post> getPostById(@PathVariable Long postId) {
        Post post = postService.getPostById(postId); // Calls service to get the post
        return ResponseEntity.ok(post); // Returns the found post
    }

    // Get all posts with pagination
    @GetMapping // This maps GET requests to get all posts
    public ResponseEntity<List<Post>> getAllPosts(
            @RequestParam(defaultValue = "0") int page, // Default page number is 0
            @RequestParam(defaultValue = "10") int size) { // Default page size is 10
        List<Post> posts = postService.getAllPosts(page, size); // Calls service to get all posts with pagination
        return ResponseEntity.ok(posts); // Returns the list of posts
    }

    // Get all posts for a specific category
    @GetMapping("/category/{categoryId}") // This maps GET requests to get posts by category ID
    public ResponseEntity<List<Post>> getPostsByCategory(@PathVariable Long categoryId) {
        List<Post> posts = postService.getPostsByCategory(categoryId); // Calls service to get posts for the category
        return ResponseEntity.ok(posts); // Returns the list of posts for that category
    }

    // Get all posts by a specific user
    @GetMapping("/user/{userId}") // This maps GET requests to get posts by user ID
    public ResponseEntity<List<Post>> getPostsByUser(@PathVariable Long userId) {
        List<Post> posts = postService.getPostsByUser(userId); // Calls service to get posts for the user
        return ResponseEntity.ok(posts); // Returns the list of posts for that user
    }

    // Delete a post by ID
    @DeleteMapping("/{postId}") // This maps DELETE requests to remove a post by its ID
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId); // Calls service to delete the post
        return ResponseEntity.noContent().build(); // Returns a response with no content (204 status)
    }
}
