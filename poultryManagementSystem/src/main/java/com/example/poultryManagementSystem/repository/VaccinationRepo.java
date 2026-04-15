package com.example.poultryManagementSystem.repository;

import com.example.poultryManagementSystem.entity.Farm;
import com.example.poultryManagementSystem.entity.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VaccinationRepo extends JpaRepository<Vaccination, Long> {

    // ✅ OLD (farmId)
    List<Vaccination> findByFarm_Id(Long farmId);
    List<Vaccination> findByFarm_IdAndDateBetween(Long farmId, LocalDate from, LocalDate to);

}