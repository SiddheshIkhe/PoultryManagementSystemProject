package com.example.poultryManagementSystem.repository;

import com.example.poultryManagementSystem.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmRepo extends JpaRepository<Farm, Long> {
    boolean existsByName(String name);
}