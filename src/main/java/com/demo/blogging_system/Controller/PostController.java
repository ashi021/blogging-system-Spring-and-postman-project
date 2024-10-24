package com.demo.blogging_system.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.demo.blogging_system.Entities.Post;
import com.demo.blogging_system.ServiceImpl.PostServiceImpl;
import com.demo.blogging_system.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostServiceImpl postService;

    // Create a new post
    @PostMapping("/user/{userId}/category/{categoryId}")
    public ResponseEntity<Post> createPost(@RequestBody Post post, 
                                           @PathVariable Long userId, 
                                           @PathVariable Long categoryId) {
        Post createdPost = postService.createPost(post, userId, categoryId);
        return ResponseEntity.ok(createdPost);
    }

    // Update an existing post
    @PutMapping("/{postId}")
    public ResponseEntity<Post> updatePost(@RequestBody Post post, @PathVariable Long postId) {
        Post updatedPost = postService.updatePost(post, postId);
        return ResponseEntity.ok(updatedPost);
    }

    // Get post by ID
    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable Long postId) {
        Post post = postService.getPostById(postId);
        return ResponseEntity.ok(post);
    }

    // Get all posts
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    // Get posts by category
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Post>> getPostsByCategory(@PathVariable Long categoryId) {
        List<Post> posts = postService.getPostsByCategory(categoryId);
        return ResponseEntity.ok(posts);
    }

    // Get posts by user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> getPostsByUser(@PathVariable Long userId) {
        List<Post> posts = postService.getPostsByUser(userId);
        return ResponseEntity.ok(posts);
    }

    // Delete a post
    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.noContent().build();
    }
}


