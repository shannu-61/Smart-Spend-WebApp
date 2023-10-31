package com.smu.smartspend.model;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer expenseid;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category categoryid;
	@Column
	private String expensescost;
	@Column
	private Date expenseDate;
	@Column
	private String notes;
}
