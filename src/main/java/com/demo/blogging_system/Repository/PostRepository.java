package com.demo.blogging_system.Repository;

import com.demo.blogging_system.Entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// This is a repository interface for managing Post entities
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    
    // This method finds posts by the category ID
    List<Post> findByCategoryCategoryId(Long categoryId);
    
    // This method finds posts by the user ID
    List<Post> findByUserUserId(Long userId);
}
