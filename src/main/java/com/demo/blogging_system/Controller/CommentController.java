package com.demo.blogging_system.Controller;

import com.demo.blogging_system.Entities.Comment;
import com.demo.blogging_system.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // This class handles HTTP requests related to comments
@RequestMapping("/api/comments") // This sets the base URL for comment-related requests
public class CommentController {

    @Autowired // This automatically injects the CommentService into this controller
    private CommentService commentService; // Service to manage comments

    // Create a new comment for a specific post by a specific user
    @PostMapping("/post/{postId}/user/{userId}") // This maps POST requests to create a comment with post and user IDs
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment, @PathVariable Long postId, @PathVariable Long userId) {
        try {
            Comment createdComment = commentService.createComment(comment, postId, userId); // Calls service to create a comment
            return ResponseEntity.ok(createdComment); // Returns the created comment
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Returns an error response if something goes wrong
        }
    }

    // Update an existing comment by ID
    @PutMapping("/{commentId}") // This maps PUT requests to update a comment by its ID
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment, @PathVariable Long commentId) {
        Comment updatedComment = commentService.updateComment(comment, commentId); // Calls service to update the comment
        return ResponseEntity.ok(updatedComment); // Returns the updated comment
    }

    // Get all comments
    @GetMapping // This maps GET requests to get all comments
    public ResponseEntity<List<Comment>> getAllComments() {
        List<Comment> comments = commentService.getAllComments(); // Calls service to get all comments
        return ResponseEntity.ok(comments); // Returns the list of comments
    }

    // Get a specific comment by ID
    @GetMapping("/{commentId}") // This maps GET requests to get a comment by its ID
    public ResponseEntity<Comment> getCommentById(@PathVariable Long commentId) {
        Comment comment = commentService.getCommentById(commentId); // Calls service to get the comment
        return ResponseEntity.ok(comment); // Returns the found comment
    }

    // Get all comments for a specific post
    @GetMapping("/post/{postId}") // This maps GET requests to get comments for a specific post by post ID
    public ResponseEntity<List<Comment>> getAllCommentsByPost(@PathVariable Long postId) {
        List<Comment> comments = commentService.getAllCommentsByPost(postId); // Calls service to get comments for the post
        return ResponseEntity.ok(comments); // Returns the list of comments for that post
    }

    // Delete a comment by ID
    @DeleteMapping("/{commentId}") // This maps DELETE requests to remove a comment by its ID
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId); // Calls service to delete the comment
        return ResponseEntity.noContent().build(); // Returns a response with no content (204 status)
    }
}
