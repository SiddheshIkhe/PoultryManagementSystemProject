package com.example.poultryManagementSystem.service;

import com.example.poultryManagementSystem.entity.Sales;
import com.example.poultryManagementSystem.repository.FarmRepo;
import com.example.poultryManagementSystem.repository.SalesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SalesService {

    private final SalesRepo salesRepo;

    @Autowired
    private FarmRepo farmRepo;


    public SalesService(SalesRepo salesRepository) {
        this.salesRepo = salesRepository;
    }

    // ✅ UPDATED SAVE (JWT + fallback)
    public Sales save(Sales sales) {

        return salesRepo.save(sales);
    }

    // ✅ OLD API (keep working)
    public List<Sales> getAllByFarm(Long farmId) {
        return salesRepo.findByFarm_Id(farmId);
    }


    // ✅ OLD API
    public List<Sales> getByFarmAndDateRange(Long farmId, LocalDate from, LocalDate to) {
        return salesRepo.findByFarm_IdAndDateBetween(farmId, from, to);
    }



    public void delete(Long id) {
        salesRepo.deleteById(id);
    }
}