package com.demo.blogging_system.ServiceImpl;

import com.demo.blogging_system.Entities.Comment;
import com.demo.blogging_system.Entities.Post;
import com.demo.blogging_system.Entities.User;
import com.demo.blogging_system.Repository.CommentRepository;
import com.demo.blogging_system.Repository.PostRepository;
import com.demo.blogging_system.Repository.UserRepository;
import com.demo.blogging_system.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository; // For accessing comments in the database

    @Autowired
    private PostRepository postRepository; // For accessing posts in the database

    @Autowired
    private UserRepository userRepository; // For accessing users in the database

    // Create a new comment for a specific post by a specific user
    @Override
    public Comment createComment(Comment comment, Long postId, Long userId) {
        // Find the post by its ID
        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new RuntimeException("Post not found"));

        // Find the user by their ID
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

        comment.setPost(post); // Set the post for this comment
        comment.setUser(user); // Set the user who made the comment
        return commentRepository.save(comment); // Save the comment to the database
    }

    // Update an existing comment by its ID
    @Override
    public Comment updateComment(Comment comment, Long commentId) {
        // Find the existing comment by its ID
        Comment existingComment = commentRepository.findById(commentId)
            .orElseThrow(() -> new RuntimeException("Comment not found"));

        existingComment.setCommentContent(comment.getCommentContent()); // Update the content of the comment
        return commentRepository.save(existingComment); // Save the updated comment
    }

    // Get a comment by its ID
    @Override
    public Comment getCommentById(Long commentId) {
        // Find and return the comment by its ID
        return commentRepository.findById(commentId)
            .orElseThrow(() -> new RuntimeException("Comment not found"));
    }

    // Get all comments for a specific post
    @Override
    public List<Comment> getAllCommentsByPost(Long postId) {
        // Find the post by its ID
        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new RuntimeException("Post not found"));

        // Fetch all comments associated with this post
        return commentRepository.findByPost(post);
    }

    // Get a list of all comments
    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll(); // Fetch all comments from the repository
    }

    // Delete a comment by its ID
    @Override
    public void deleteComment(Long commentId) {
        // Find the comment by its ID
        Comment comment = commentRepository.findById(commentId)
            .orElseThrow(() -> new RuntimeException("Comment not found"));

        commentRepository.delete(comment); // Delete the found comment from the database
    }
}
