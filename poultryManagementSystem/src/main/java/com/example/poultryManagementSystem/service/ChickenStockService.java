package com.example.poultryManagementSystem.service;

import com.example.poultryManagementSystem.entity.ChickenStock;

import com.example.poultryManagementSystem.repository.ChickenStockRepo;
import com.example.poultryManagementSystem.repository.FarmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ChickenStockService {

    private final ChickenStockRepo chickenStockRepo;

    public ChickenStockService(ChickenStockRepo chickenStockRepository) {
        this.chickenStockRepo = chickenStockRepository;
    }

    public ChickenStock save(ChickenStock chickenStock) {
        if (chickenStockRepo.existsByFarm_IdAndDate(
                chickenStock.getFarm().getId(),
                chickenStock.getDate()
        )) {
            throw new RuntimeException("Duplicate entry");
        }
        return chickenStockRepo.save(chickenStock);
    }
    // ✅ OLD API (keep it working)
    public List<ChickenStock> getAllByFarm(Long farmId) {
        return chickenStockRepo.findByFarm_Id(farmId);
    }



    // ✅ OLD API
    public List<ChickenStock> getByFarmAndDate(Long farmId, LocalDate date) {
        return chickenStockRepo.findByFarm_IdAndDate(farmId, date);
    }



    // ✅ OLD API
    public List<ChickenStock> getByFarmAndDateRange(Long farmId, LocalDate from, LocalDate to) {
        return chickenStockRepo.findByFarm_IdAndDateBetween(farmId, from, to);
    }



    public void delete(Long id) {
        chickenStockRepo.deleteById(id);
    }
}