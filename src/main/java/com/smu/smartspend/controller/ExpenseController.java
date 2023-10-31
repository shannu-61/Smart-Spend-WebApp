package com.smu.smartspend.controller;

import com.smu.smartspend.model.Category;
import com.smu.smartspend.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.smu.smartspend.model.Expense;
import com.smu.smartspend.service.ExpenseService;

import java.util.List;

@Slf4j
@Controller
public class ExpenseController {

    private final ExpenseService expenseService;
    private final CategoryService categoryService;

    @Autowired
    public ExpenseController(ExpenseService expenseService, CategoryService categoryService) {
        this.expenseService = expenseService;
        this.categoryService = categoryService;
    }

    @GetMapping("/expenses")
    public String listExpenses(Model model) {
        model.addAttribute("categories",categoryService.findByCategoryType("Expense"));
        model.addAttribute("expenses", expenseService.findAll());
        return "expenses";
    }

    @GetMapping("/add-expense")
    public String addExpense(Model model) {
        model.addAttribute("expense", new Expense());
        model.addAttribute("categories", categoryService.findByCategoryType("Expense"));
        return "add-edit-expense";
    }

    @PostMapping("/create-update-expense")
    public String createUpdateExpense(Expense expense) {
        expenseService.addEditExpense(expense);
        return "redirect:/expenses";
    }

    @GetMapping("/edit-expense/{id}")
    public String editExpense(@PathVariable("id") Integer expenseId, Model model) {
        Expense expense = expenseService.findExpenseById(expenseId);
        model.addAttribute("categories", categoryService.findByCategoryType("Expense"));
        model.addAttribute("expense", expense);
        return "add-edit-expense";
    }

    @GetMapping("/delete-expense/{id}")
    public String deleteExpense(@PathVariable("id") Integer expenseId) {
        expenseService.deleteById(expenseId);
        return "redirect:/expenses";
    }
}
