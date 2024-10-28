package com.demo.blogging_system.Controller;

import com.demo.blogging_system.Entities.Category;
import com.demo.blogging_system.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // This class handles incoming requests and sends responses
@RequestMapping("/api/categories") // This sets the base URL for category-related requests
public class CategoryController {

    @Autowired // This automatically injects the CategoryService into this controller
    private CategoryService categoryService; // Service to manage categories

    // Create a new category
    @PostMapping // This maps POST requests to this method
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category createdCategory = categoryService.createCategory(category); // Calls service to create a category
        return ResponseEntity.ok(createdCategory); // Returns the created category
    }

    // Update an existing category
    @PutMapping("/{categoryId}") // This maps PUT requests to this method with a category ID
    public ResponseEntity<Category> updateCategory(@RequestBody Category category, @PathVariable Long categoryId) {
        Category updatedCategory = categoryService.updateCategory(category, categoryId); // Calls service to update the category
        return ResponseEntity.ok(updatedCategory); // Returns the updated category
    }

    // Get category by ID
    @GetMapping("/{categoryId}") // This maps GET requests to get a category by ID
    public ResponseEntity<Category> getCategoryById(@PathVariable Long categoryId) {
        Category category = categoryService.getCategoryById(categoryId); // Calls service to get the category
        return ResponseEntity.ok(category); // Returns the found category
    }

    // Get all categories
    @GetMapping // This maps GET requests to get all categories
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories(); // Calls service to get all categories
        return ResponseEntity.ok(categories); // Returns the list of categories
    }

    // Delete a category
    @DeleteMapping("/{categoryId}") // This maps DELETE requests to remove a category by ID
    public ResponseEntity<Void> deleteCategory(@PathVariable Long categoryId) {
        categoryService.deleteCategory(categoryId); // Calls service to delete the category
        return ResponseEntity.noContent().build(); // Returns a response with no content (204 status)
    }
}
