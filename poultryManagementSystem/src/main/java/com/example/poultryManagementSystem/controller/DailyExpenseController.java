package com.example.poultryManagementSystem.controller;

import com.example.poultryManagementSystem.entity.DailyExpense;
import com.example.poultryManagementSystem.service.DailyExpenseService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/expense")
@CrossOrigin(origins = "*")
public class DailyExpenseController {

    private final DailyExpenseService dailyExpenseService;

    public DailyExpenseController(DailyExpenseService dailyExpenseService) {
        this.dailyExpenseService = dailyExpenseService;
    }

    // ✅ CREATE (JWT auto farm OR old farmId)
    @PostMapping
    public DailyExpense save(@RequestBody DailyExpense dailyExpense) {
        return dailyExpenseService.save(dailyExpense);
    }


    @GetMapping("/{farmId}")
    public List<DailyExpense> getAllByFarm(@PathVariable Long farmId) {
        return dailyExpenseService.getAllByFarm(farmId);
    }

    @GetMapping("/{farmId}/filter")
    public List<DailyExpense> getByDateRange(
            @PathVariable Long farmId,
            @RequestParam LocalDate from,
            @RequestParam LocalDate to) {
        return dailyExpenseService.getByFarmAndDateRange(farmId, from, to);
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        dailyExpenseService.delete(id);
        return "Expense deleted successfully";
    }
}