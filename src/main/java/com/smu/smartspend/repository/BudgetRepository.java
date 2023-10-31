package com.smu.smartspend.repository;

import com.smu.smartspend.model.Budget;
import org.springframework.data.repository.CrudRepository;

import java.time.YearMonth;
import java.util.Optional;

public interface BudgetRepository extends CrudRepository<Budget, Integer> {
    Optional<Budget> findByCategory_CategoryIdAndAndBudgetMonth(Integer category, YearMonth budgetMonth);
}
