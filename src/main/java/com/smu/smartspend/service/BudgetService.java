package com.smu.smartspend.service;

import com.smu.smartspend.model.Budget;

import java.util.List;

public interface BudgetService {
    void addBudget(Budget budget);
    List<Budget> getAllBudgets();
    Budget getBudgetById(Integer budgetId);
    void updateBudget(Budget budget);
    void deleteBudget(Integer budgetId);
}
