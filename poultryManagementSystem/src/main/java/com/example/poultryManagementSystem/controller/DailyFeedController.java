package com.example.poultryManagementSystem.controller;

import com.example.poultryManagementSystem.entity.DailyFeed;
import com.example.poultryManagementSystem.service.DailyFeedService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/feed")
@CrossOrigin(origins = "*")
public class DailyFeedController {

    private final DailyFeedService dailyFeedService;

    public DailyFeedController(DailyFeedService dailyFeedService) {
        this.dailyFeedService = dailyFeedService;
    }

    // ✅ CREATE (JWT auto farm OR old farmId)
    @PostMapping
    public DailyFeed save(@RequestBody DailyFeed dailyFeed) {
        return dailyFeedService.save(dailyFeed);
    }



    @GetMapping("/{farmId}")
    public List<DailyFeed> getAllByFarm(@PathVariable Long farmId) {
        return dailyFeedService.getAllByFarm(farmId);
    }

    @GetMapping("/{farmId}/filter")
    public List<DailyFeed> getByDateRange(
            @PathVariable Long farmId,
            @RequestParam LocalDate from,
            @RequestParam LocalDate to) {
        return dailyFeedService.getByFarmAndDateRange(farmId, from, to);
    }



    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        dailyFeedService.delete(id);
        return "Feed record deleted successfully";
    }
}