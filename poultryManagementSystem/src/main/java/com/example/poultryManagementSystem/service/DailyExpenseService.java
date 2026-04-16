package com.example.poultryManagementSystem.service;

import com.example.poultryManagementSystem.entity.DailyExpense;

import com.example.poultryManagementSystem.repository.DailyExpenseRepo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DailyExpenseService {

    private final DailyExpenseRepo dailyExpenseRepo;

    public DailyExpense save(DailyExpense dailyExpense) {
        if (dailyExpenseRepo.existsByFarm_IdAndDate(
                dailyExpense.getFarm().getId(),
                dailyExpense.getDate()
        )) {
            throw new RuntimeException("Duplicate entry");
        }
        return dailyExpenseRepo.save(dailyExpense);
    }


    public DailyExpenseService(DailyExpenseRepo dailyExpenseRepository) {
        this.dailyExpenseRepo = dailyExpenseRepository;
    }



    // ✅ OLD API (keep working)
    public List<DailyExpense> getAllByFarm(Long farmId) {
        return dailyExpenseRepo.findByFarm_Id(farmId);
    }



    // ✅ OLD API
    public List<DailyExpense> getByFarmAndDateRange(Long farmId, LocalDate from, LocalDate to) {
        return dailyExpenseRepo.findByFarm_IdAndDateBetween(farmId, from, to);
    }



    public void delete(Long id) {
        dailyExpenseRepo.deleteById(id);
    }
}