package com.example.poultryManagementSystem.repository;

import com.example.poultryManagementSystem.entity.EggProduction;
import com.example.poultryManagementSystem.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EggProductionRepo extends JpaRepository<EggProduction, Long> {

    // ✅ OLD (farmId)
    List<EggProduction> findByFarm_Id(Long farmId);
    List<EggProduction> findByFarm_IdAndDateBetween(Long farmId, LocalDate from, LocalDate to);

}