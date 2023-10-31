package com.smu.smartspend.service;

import com.smu.smartspend.model.Budget;
import com.smu.smartspend.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class BudgetServiceImpl implements BudgetService {
    private final BudgetRepository budgetRepository;

    @Autowired
    public BudgetServiceImpl(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    @Override
    public void addBudget(Budget budget) {
        Optional<Budget> existingBudget=budgetRepository.findByCategory_CategoryIdAndAndBudgetMonth(budget.getCategory().getCategoryId(),budget.getBudgetMonth());
        if(existingBudget.isPresent()){
            Budget updateBudget=existingBudget.get();
            updateBudget.setCategory(budget.getCategory());
            updateBudget.setBudgetAmount(budget.getBudgetAmount());
            updateBudget.setBudgetMonth(updateBudget.getBudgetMonth());
            budgetRepository.save(updateBudget);
            return;
        }
        budgetRepository.save(budget);
    }

    @Override
    public List<Budget> getAllBudgets() {
        return (List<Budget>) budgetRepository.findAll();
    }

    @Override
    public Budget getBudgetById(Integer budgetId) {
        return budgetRepository.findById(budgetId).orElse(null);
    }

    @Override
    public void updateBudget(Budget budget) {
        budgetRepository.save(budget);
    }

    @Override
    public void deleteBudget(Integer budgetId) {
        budgetRepository.deleteById(budgetId);
    }

}
