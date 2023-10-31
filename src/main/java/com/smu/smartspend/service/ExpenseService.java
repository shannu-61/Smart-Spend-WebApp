package com.smu.smartspend.service;

import com.smu.smartspend.model.Expense;

public interface ExpenseService {
	void addEditExpense(Expense expense);

	Expense findExpenseById(Integer expenseId);

	void deleteById(Integer expenseId);

	Iterable<Expense> findAll();
}
