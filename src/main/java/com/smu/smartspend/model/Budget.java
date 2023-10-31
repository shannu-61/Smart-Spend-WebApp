package com.smu.smartspend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.YearMonth;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer budgetId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column
    private BigDecimal budgetAmount;

    @Column
    @Convert(converter = YearMonthAttributeConverter.class)
    private YearMonth budgetMonth;
}
