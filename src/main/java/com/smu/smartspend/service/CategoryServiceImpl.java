package com.smu.smartspend.service;

import com.smu.smartspend.model.Category;
import com.smu.smartspend.model.CategoryType;
import com.smu.smartspend.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public void addEditCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category findCategoryById(Integer categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    @Override
    public Iterable<Category> findByCategoryType(String type) {

        return categoryRepository.findByCategoryType(Enum.valueOf(CategoryType.class,type));
    }

    @Override
    public void deleteById(Integer categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
