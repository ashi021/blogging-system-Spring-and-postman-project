package com.demo.blogging_system.Service;

import com.demo.blogging_system.Entities.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(Comment comment, Long postId);
    Comment updateComment(Comment comment, Long commentId);
    Comment getCommentById(Long commentId);
    List<Comment> getAllCommentsByPost(Long postId);
    void deleteComment(Long commentId);
}

