package com.demo.blogging_system.Repository;

import com.demo.blogging_system.Entities.Comment;
import com.demo.blogging_system.Entities.Post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	// Custom method to find all comments for a specific post
    List<Comment> findByPost(Post post);
}

