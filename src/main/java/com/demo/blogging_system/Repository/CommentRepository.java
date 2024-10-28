package com.demo.blogging_system.Repository;

import com.demo.blogging_system.Entities.Comment;
import com.demo.blogging_system.Entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    // Fetch comments based on the post entity
    List<Comment> findByPost(Post post);
}
