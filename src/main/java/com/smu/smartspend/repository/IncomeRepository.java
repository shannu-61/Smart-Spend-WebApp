package com.smu.smartspend.repository;

import com.smu.smartspend.model.Income;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface IncomeRepository extends CrudRepository<Income, Long> {
    @Query("SELECT sum(amount) from Income i where MONTH(i.date) = :month AND YEAR(i.date) = :year")
    BigDecimal getSumByMonthAndYear(@Param("month")int month,@Param("year")int year);
}
