package com.smu.smartspend.repository;

import com.smu.smartspend.model.Category;
import com.smu.smartspend.model.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Iterable<Category> findByCategoryType(CategoryType type);
}
