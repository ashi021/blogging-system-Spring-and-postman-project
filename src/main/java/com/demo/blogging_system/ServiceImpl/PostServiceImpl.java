package com.demo.blogging_system.ServiceImpl;

import com.demo.blogging_system.Entities.Category;
import com.demo.blogging_system.Entities.Post;
import com.demo.blogging_system.Entities.User;
import com.demo.blogging_system.Repository.CategoryRepository;
import com.demo.blogging_system.Repository.PostRepository;
import com.demo.blogging_system.Repository.UserRepository;
import com.demo.blogging_system.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Post createPost(Post post, Long userId, Long categoryId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        Category category = categoryRepository.findById(categoryId)
            .orElseThrow(() -> new RuntimeException("Category not found"));

        post.setUser(user);
        post.setCategory(category);
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Post post, Long postId) {
        Post existingPost = postRepository.findById(postId)
            .orElseThrow(() -> new RuntimeException("Post not found"));

        existingPost.setPostTitle(post.getPostTitle());
        existingPost.setPostContent(post.getPostContent());
        return postRepository.save(existingPost);
    }

    @Override
    public Post getPostById(Long postId) {
        return postRepository.findById(postId)
            .orElseThrow(() -> new RuntimeException("Post not found"));
    }

    @Override
    public List<Post> getPostsByCategory(Long categoryId) {
        return postRepository.findByCategoryCategoryId(categoryId);
    }

    @Override
    public List<Post> getPostsByUser(Long userId) {
        return postRepository.findByUserUserId(userId);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new RuntimeException("Post not found"));
        postRepository.delete(post);
    }
}

