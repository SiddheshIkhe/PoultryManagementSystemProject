package com.example.poultryManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Optional;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "userTable")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // ✅ FIXED ID
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String role;

    @JsonBackReference("farm-user")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "farm_id", nullable = false)
    @ToString.Exclude
    private Farm farm;
}