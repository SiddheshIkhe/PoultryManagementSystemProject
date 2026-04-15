package com.example.poultryManagementSystem.entity;

import com.example.poultryManagementSystem.entity.Farm;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyExpense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String descriptionOfExpense;
    private Long amount;

    @JsonBackReference("farm-expense")
    @ManyToOne
    @JoinColumn(name = "farm_id")
    private Farm farm;

    @PrePersist
    public void prePersist() {
        if (this.date == null) this.date = LocalDate.now();
    }
}