package com.demo.blogging_system.Repository;

import com.demo.blogging_system.Entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    // Custom query to find posts by category ID
    List<Post> findByCategoryCategoryId(Long categoryId);
    
    // Custom query to find posts by user ID
    List<Post> findByUserUserId(Long userId);
}

