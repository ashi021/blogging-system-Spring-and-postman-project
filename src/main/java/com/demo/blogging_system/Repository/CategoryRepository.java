package com.demo.blogging_system.Repository;

import com.demo.blogging_system.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Custom query to find category by name (optional if needed)
    Category findByCategoryName(String categoryName);
}

