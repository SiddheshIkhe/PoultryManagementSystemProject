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
public class Vaccination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private String vaccineName;

    private Long ageOfBirds;

    private Long totalBirdsVaccinated;

    private String vaccineBatchNumber;

    private LocalDate nextDueDate;

    private Long costOfVaccine;

    private String administeredBy;

    private String remark;

    @JsonBackReference("farm-vaccination")   // ✅ MATCH WITH FARM
    @ManyToOne
    @JoinColumn(name = "farm_id")            // ✅ FIXED COLUMN NAME
    private Farm farm;
}