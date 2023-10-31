package com.smu.smartspend.controller;

import com.smu.smartspend.model.Budget;
import com.smu.smartspend.service.BudgetService;
import com.smu.smartspend.service.CategoryService;
import com.smu.smartspend.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BudgetController {

    private final BudgetService budgetService;
    private final CategoryService categoryService;
    private final IncomeService incomeService;

    @Autowired
    public BudgetController(BudgetService budgetService, CategoryService categoryService, IncomeService incomeService) {
        this.budgetService = budgetService;
        this.categoryService = categoryService;
        this.incomeService = incomeService;
    }

    @GetMapping("/budgets")
    public String showBudgetList(Model model) {
        List<Budget> budgets = budgetService.getAllBudgets();

        Map<BigDecimal,Budget> budgetData=new HashMap<>();
        for (Budget budget:budgets) {
            budgetData.put(incomeService.getSumByMonthAndYear(budget.getBudgetMonth().getMonthValue(),budget.getBudgetMonth().getYear()),budget);

        }

        model.addAttribute("budgetsData", budgetData);

        return "budget-list";
    }

    @GetMapping("/budgets/add")
    public String showAddBudgetForm(Model model) {
        model.addAttribute("budget", new Budget());
        model.addAttribute("categories", categoryService.findByCategoryType("Expense"));
        return "budget-form";
    }

    @PostMapping("/budgets/add")
    public String addBudget(@ModelAttribute("budget") Budget budget) {
        budgetService.addBudget(budget);
        return "redirect:/budgets";
    }

    @GetMapping("/budgets/edit/{budgetId}")
    public String showEditBudgetForm(@PathVariable Integer budgetId, Model model) {
        Budget budget = budgetService.getBudgetById(budgetId);
        model.addAttribute("categories", categoryService.findByCategoryType("Expense"));
        model.addAttribute("budget", budget);
        return "budget-form";
    }

    @PostMapping("/budgets/edit/{budgetId}")
    public String editBudget(@ModelAttribute("budget") Budget budget, @PathVariable Integer budgetId) {
        budget.setBudgetId(budgetId);
        budgetService.updateBudget(budget);
        return "redirect:/budgets";
    }

    @GetMapping("/budgets/delete/{budgetId}")
    public String deleteBudget(@PathVariable Integer budgetId) {
        budgetService.deleteBudget(budgetId);
        return "redirect:/budgets";
    }
}
