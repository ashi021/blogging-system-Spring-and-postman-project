package com.demo.blogging_system.ServiceImpl;

import com.demo.blogging_system.Entities.Category;
import com.demo.blogging_system.Repository.CategoryRepository;
import com.demo.blogging_system.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Create a new category and save it to the database
    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Update an existing category based on the provided category ID
    @Override
    public Category updateCategory(Category category, Long categoryId) {
        // Find the existing category by ID
        Category existingCategory = categoryRepository.findById(categoryId)
            .orElseThrow(() -> new RuntimeException("Category not found"));

        // Update the category name
        existingCategory.setCategoryName(category.getCategoryName());

        // Save the updated category back to the database
        return categoryRepository.save(existingCategory);
    }

    // Get a category by its ID
    @Override
    public Category getCategoryById(Long categoryId) {
        // Find and return the category by ID
        return categoryRepository.findById(categoryId)
            .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    // Get a list of all categories
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Delete a category by its ID
    @Override
    public void deleteCategory(Long categoryId) {
        // Find the category by ID
        Category category = categoryRepository.findById(categoryId)
            .orElseThrow(() -> new RuntimeException("Category not found"));
        // Delete the found category
        categoryRepository.delete(category);
    }
}
