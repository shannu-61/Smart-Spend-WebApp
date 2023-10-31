package com.smu.smartspend.service;

import com.smu.smartspend.model.Category;
import java.util.List;

public interface CategoryService {
    void addEditCategory(Category category);
    Category findCategoryById(Integer categoryId);
    Iterable<Category> findByCategoryType(String type);
    void deleteById(Integer categoryId);
    List<Category> findAll();
}
