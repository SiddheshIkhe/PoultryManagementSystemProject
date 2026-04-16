package com.example.poultryManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   // ✅ standardized

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    private Long capacity;

    private LocalDate createdOn;

    @PrePersist
    public void prePersist() {
        this.createdOn = LocalDate.now();   // ✅ auto date
    }

    @JsonManagedReference("farm-chicken")
    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChickenStock> chickenStocks;

    @JsonManagedReference("farm-user")
    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<User> users;

    @JsonManagedReference("farm-expense")
    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DailyExpense> expenses;

    @JsonManagedReference("farm-feed")
    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DailyFeed> feeds;

    @JsonManagedReference("farm-egg")
    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EggProduction> eggProductions;

    @JsonManagedReference("farm-sales")
    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sales> sales;

    @JsonManagedReference("farm-vaccination")
    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vaccination> vaccinations;
}