package com.smu.smartspend.repository;

import com.smu.smartspend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import com.smu.smartspend.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
    Expense findExpenseByExpenseid(Integer expenseid);
    Expense findExpenseByCategoryid(Category category);
}

