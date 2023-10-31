package com.smu.smartspend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.smu.smartspend.model.Category;
import com.smu.smartspend.service.CategoryService;

@Slf4j
@Controller
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "categories";
    }

    @GetMapping("/add-category")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "add-edit-category";
    }

    @PostMapping("/create-update-category")
    public String createUpdateCategory(Category category) {
        categoryService.addEditCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/edit-category/{id}")
    public String editCategory(@PathVariable("id") Integer categoryId, Model model) {
        Category category = categoryService.findCategoryById(categoryId);
        model.addAttribute("category", category);
        return "add-edit-category";
    }

    @GetMapping("/delete-category/{id}")
    public String deleteCategory(@PathVariable("id") Integer categoryId) {
        categoryService.deleteById(categoryId);
        return "redirect:/categories";
    }

    @GetMapping("/filter-by-type/{type}")
    public String filterByCategoryType(@PathVariable("type") String type, Model model) {
        model.addAttribute("categories", categoryService.findByCategoryType(type));
        return "categories";
    }
}
