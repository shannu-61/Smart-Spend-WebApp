package com.smu.smartspend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.smu.smartspend.model.Expense;
import com.smu.smartspend.repository.ExpenseRepository;

@RequiredArgsConstructor
@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Override
    public void addEditExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    @Override
    public Expense findExpenseById(Integer expenseId) {
        return expenseRepository.findById(expenseId).orElse(null);
    }

    @Override
    public void deleteById(Integer expenseId) {
        expenseRepository.deleteById(expenseId);
    }

    @Override
    public Iterable<Expense> findAll() {
        return expenseRepository.findAll();
    }
}
