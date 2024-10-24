package com.demo.blogging_system.ServiceImpl;

import com.demo.blogging_system.Entities.Comment;
import com.demo.blogging_system.Entities.Post;
import com.demo.blogging_system.Repository.CommentRepository;
import com.demo.blogging_system.Repository.PostRepository;
import com.demo.blogging_system.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public Comment createComment(Comment comment, Long postId) {
        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new RuntimeException("Post not found"));

        comment.setPost(post);
        return commentRepository.save(comment);
    }


    @Override
    public Comment updateComment(Comment comment, Long commentId) {
        Comment existingComment = commentRepository.findById(commentId)
            .orElseThrow(() -> new RuntimeException("Comment not found"));

        existingComment.setCommentContent(comment.getCommentContent());

        return commentRepository.save(existingComment);
    }

    @Override
    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId)
            .orElseThrow(() -> new RuntimeException("Comment not found"));
    }

    @Override
    public List<Comment> getAllCommentsByPost(Long postId) {
        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new RuntimeException("Post not found"));

        return commentRepository.findByPost(post);
    }


    @Override
    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
            .orElseThrow(() -> new RuntimeException("Comment not found"));

        commentRepository.delete(comment);
    }
}

