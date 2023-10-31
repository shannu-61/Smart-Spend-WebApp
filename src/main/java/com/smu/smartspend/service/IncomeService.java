package com.smu.smartspend.service;

import com.smu.smartspend.model.Income;

import java.math.BigDecimal;
import java.util.List;

public interface IncomeService {
    List<Income> getAllIncomes();
    Income getIncomeById(Long id);
    void addIncome(Income income);
    void updateIncome(Income income);
    void deleteIncome(Long id);
    public BigDecimal getSumByMonthAndYear(int month, int year);
}
