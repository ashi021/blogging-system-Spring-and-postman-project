package com.demo.blogging_system.Service;

import com.demo.blogging_system.Entities.Comment;
import java.util.List;

// This is an interface for Comment service operations
public interface CommentService {
    
    // Method to create a new comment for a specific post by a user
    Comment createComment(Comment comment, Long postId, Long userId);
    
    // Method to update an existing comment by its ID
    Comment updateComment(Comment comment, Long commentId);
    
    // Method to get a list of all comments
    List<Comment> getAllComments();
    
    // Method to get a specific comment by its ID
    Comment getCommentById(Long commentId);
    
    // Method to get all comments for a specific post
    List<Comment> getAllCommentsByPost(Long postId);
    
    // Method to delete a comment by its ID
    void deleteComment(Long commentId);
}
