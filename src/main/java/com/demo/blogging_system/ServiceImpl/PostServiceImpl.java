package com.demo.blogging_system.ServiceImpl;

import com.demo.blogging_system.Entities.Category;
import com.demo.blogging_system.Entities.Post;
import com.demo.blogging_system.Entities.User;
import com.demo.blogging_system.Repository.CategoryRepository;
import com.demo.blogging_system.Repository.PostRepository;
import com.demo.blogging_system.Repository.UserRepository;
import com.demo.blogging_system.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository; // For accessing posts in the database

    @Autowired
    private UserRepository userRepository; // For accessing users in the database

    @Autowired
    private CategoryRepository categoryRepository; // For accessing categories in the database

    // Create a new post linked to a specific user and category
    @Override
    public Post createPost(Post post, Long userId, Long categoryId) {
        // Find the user by their ID
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        
        // Find the category by its ID
        Category category = categoryRepository.findById(categoryId)
            .orElseThrow(() -> new RuntimeException("Category not found"));

        post.setUser(user); // Set the user who created the post
        post.setCategory(category); // Set the category for this post
        return postRepository.save(post); // Save the new post to the database
    }

    // Update an existing post by its ID
    @Override
    public Post updatePost(Post post, Long postId) {
        // Find the existing post by its ID
        Post existingPost = postRepository.findById(postId)
            .orElseThrow(() -> new RuntimeException("Post not found"));

        existingPost.setPostTitle(post.getPostTitle()); // Update the title of the post
        existingPost.setPostContent(post.getPostContent()); // Update the content of the post
        return postRepository.save(existingPost); // Save the updated post
    }

    // Get a post by its ID
    @Override
    public Post getPostById(Long postId) {
        // Find and return the post by its ID
        return postRepository.findById(postId)
            .orElseThrow(() -> new RuntimeException("Post not found"));
    }

    // Get all posts for a specific category
    @Override
    public List<Post> getPostsByCategory(Long categoryId) {
        // Fetch all posts that belong to this category
        return postRepository.findByCategoryCategoryId(categoryId);
    }

    // Get all posts created by a specific user
    @Override
    public List<Post> getPostsByUser(Long userId) {
        // Fetch all posts created by this user
        return postRepository.findByUserUserId(userId);
    }

    // Get a list of all posts with pagination
    @Override
    public List<Post> getAllPosts(int page, int size) {
        // Get a page of posts
        Page<Post> postPage = postRepository.findAll(PageRequest.of(page, size));
        return postPage.getContent(); // Return the content (list of posts) from the page
    }

    // Delete a post by its ID
    @Override
    public void deletePost(Long postId) {
        // Find the post by its ID
        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new RuntimeException("Post not found"));
        
        postRepository.delete(post); // Delete the found post from the database
    }
}
