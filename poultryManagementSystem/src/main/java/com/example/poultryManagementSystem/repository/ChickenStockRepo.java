package com.example.poultryManagementSystem.repository;

import com.example.poultryManagementSystem.entity.ChickenStock;
import com.example.poultryManagementSystem.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ChickenStockRepo extends JpaRepository<ChickenStock, Long> {


    List<ChickenStock> findByFarm_Id(Long farmId);

    List<ChickenStock> findByFarm_IdAndDate(Long farmId, LocalDate date);

    List<ChickenStock> findByFarm_IdAndDateBetween(Long farmId, LocalDate from, LocalDate to);



}