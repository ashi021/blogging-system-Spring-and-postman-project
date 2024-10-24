package com.demo.blogging_system.Controller;

import com.demo.blogging_system.Entities.Comment;
import com.demo.blogging_system.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // Create a new comment for a specific post
    @PostMapping("/post/{postId}")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment, @PathVariable Long postId) {
        Comment createdComment = commentService.createComment(comment, postId);
        return ResponseEntity.ok(createdComment);
    }

    // Update an existing comment
    @PutMapping("/{commentId}")
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment, @PathVariable Long commentId) {
        Comment updatedComment = commentService.updateComment(comment, commentId);
        return ResponseEntity.ok(updatedComment);
    }

    // Get comment by ID
    @GetMapping("/{commentId}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long commentId) {
        Comment comment = commentService.getCommentById(commentId);
        return ResponseEntity.ok(comment);
    }

    // Get all comments for a specific post
    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Comment>> getAllCommentsByPost(@PathVariable Long postId) {
        List<Comment> comments = commentService.getAllCommentsByPost(postId);
        return ResponseEntity.ok(comments);
    }

    // Delete a comment
    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }
}

