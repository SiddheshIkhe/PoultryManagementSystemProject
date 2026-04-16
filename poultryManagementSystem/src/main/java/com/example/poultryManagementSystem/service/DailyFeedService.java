package com.example.poultryManagementSystem.service;

import com.example.poultryManagementSystem.entity.DailyFeed;

import com.example.poultryManagementSystem.repository.DailyFeedRepo;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Service
public class DailyFeedService {

    private final DailyFeedRepo dailyFeedRepo;



    public DailyFeedService(DailyFeedRepo dailyFeedRepository) {
        this.dailyFeedRepo = dailyFeedRepository;
    }

    public DailyFeed save(DailyFeed dailyFeed) {
        if (dailyFeedRepo.existsByFarm_IdAndDate(
                dailyFeed.getFarm().getId(),
                dailyFeed.getDate()
        )) {
            throw new RuntimeException("Duplicate entry");
        }
        return dailyFeedRepo.save(dailyFeed);
    }
    // ✅ OLD API (keep working)
    public List<DailyFeed> getAllByFarm(Long farmId) {
        return dailyFeedRepo.findByFarm_Id(farmId);
    }



    // ✅ OLD API
    public List<DailyFeed> getByFarmAndDateRange(Long farmId, LocalDate from, LocalDate to) {
        return dailyFeedRepo.findByFarm_IdAndDateBetween(farmId, from, to);
    }



    public void delete(Long id) {
        dailyFeedRepo.deleteById(id);
    }
}