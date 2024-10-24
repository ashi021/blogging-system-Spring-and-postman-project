package com.demo.blogging_system.Service;

import com.demo.blogging_system.Entities.Post;

import java.util.List;

public interface PostService {
    Post createPost(Post post, Long userId, Long categoryId);
    Post updatePost(Post post, Long postId);
    Post getPostById(Long postId);
    List<Post> getPostsByCategory(Long categoryId);
    List<Post> getPostsByUser(Long userId);
    List<Post> getAllPosts();
    void deletePost(Long postId);
}
