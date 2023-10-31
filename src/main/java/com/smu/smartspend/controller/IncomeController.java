package com.smu.smartspend.controller;

import com.smu.smartspend.model.Income;
import com.smu.smartspend.service.CategoryService;
import com.smu.smartspend.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IncomeController {
    private final IncomeService incomeService;
    private final CategoryService categoryService;

    @Autowired
    public IncomeController(IncomeService incomeService, CategoryService categoryService) {
        this.incomeService = incomeService;
        this.categoryService = categoryService;
    }

    @GetMapping("/income")
    public String showAllIncomes(Model model) {
        model.addAttribute("incomes", incomeService.getAllIncomes());
        return "income-list";
    }

    @GetMapping("/income/add")
    public String showAddIncomeForm(Model model) {
        model.addAttribute("income", new Income());
        model.addAttribute("categories", categoryService.findAll());
        return "income-form";
    }

    @PostMapping("/income/add")
    public String addIncome(@ModelAttribute Income income) {
        incomeService.addIncome(income);
        return "redirect:/income";
    }

    @GetMapping("/income/edit/{id}")
    public String showEditIncomeForm(@PathVariable Long id, Model model) {
        Income income = incomeService.getIncomeById(id);
        if (income == null) {
            return "redirect:/income";
        }
        model.addAttribute("income", income);
        model.addAttribute("categories", categoryService.findAll());
        return "/income-form";
    }

    @PostMapping("/income/edit/{id}")
    public String editIncome(@PathVariable Long id, @ModelAttribute Income income) {
        Income existingIncome = incomeService.getIncomeById(id);
        if (existingIncome == null) {
            return "redirect:/income";
        }
        income.setId(existingIncome.getId());
        incomeService.updateIncome(income);
        return "redirect:/income";
    }

    @GetMapping("/income/delete/{id}")
    public String deleteIncome(@PathVariable Long id) {
        incomeService.deleteIncome(id);
        return "redirect:/income";
    }
}
