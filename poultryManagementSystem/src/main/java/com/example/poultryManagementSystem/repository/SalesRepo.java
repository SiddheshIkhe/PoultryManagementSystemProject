package com.example.poultryManagementSystem.repository;

import com.example.poultryManagementSystem.entity.Farm;
import com.example.poultryManagementSystem.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SalesRepo extends JpaRepository<Sales, Long> {

    // ✅ OLD (farmId)
    List<Sales> findByFarm_Id(Long farmId);
    List<Sales> findByFarm_IdAndDateBetween(Long farmId, LocalDate from, LocalDate to);

}