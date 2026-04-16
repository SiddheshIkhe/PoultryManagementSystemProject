package com.example.poultryManagementSystem.entity;

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
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private Integer numberOfTrays;
    private Long totalEggs;
    private Double rate;
    private Long totalAmount;
    private String paymentMethod;

    @JsonBackReference("farm-sales")
    @ManyToOne
    @JoinColumn(name = "farm_id")
    private Farm farm;

    @PrePersist
    public void prePersist() {
        if (this.date == null) this.date = LocalDate.now();
    }
}