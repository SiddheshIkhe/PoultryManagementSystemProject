package com.example.poultryManagementSystem.repository;

import com.example.poultryManagementSystem.entity.DailyFeed;
import com.example.poultryManagementSystem.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DailyFeedRepo extends JpaRepository<DailyFeed, Long> {

    // ✅ OLD (farmId)
    List<DailyFeed> findByFarm_Id(Long farmId);
    List<DailyFeed> findByFarm_IdAndDateBetween(Long farmId, LocalDate from, LocalDate to);

    boolean existsByFarm_IdAndDate(Long farmId, LocalDate date);

}