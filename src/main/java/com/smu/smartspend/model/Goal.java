package com.smu.smartspend.model;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "goal")
public final class Goal {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer goalid;
	@Column
	private String goalname;
	@Column
	private String goalcost;
	@Column
	private Date goaldeadline;
	@Column
	private String currentsavings;
	@Column
	private  boolean status;
	@Column
	private  boolean archive;

}