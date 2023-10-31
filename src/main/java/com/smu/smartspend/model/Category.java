package com.smu.smartspend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Integer categoryId;
    @Column
    String categoryName;
    @Enumerated(EnumType.STRING)
    CategoryType categoryType;

}
