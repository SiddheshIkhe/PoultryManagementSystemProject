package com.example.poultryManagementSystem.repository;

import com.example.poultryManagementSystem.entity.DailyExpense;
import com.example.poultryManagementSystem.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DailyExpenseRepo extends JpaRepository<DailyExpense, Long> {

    // ✅ OLD (farmId)
    List<DailyExpense> findByFarm_Id(Long farmId);
    List<DailyExpense> findByFarm_IdAndDateBetween(Long farmId, LocalDate from, LocalDate to);


}