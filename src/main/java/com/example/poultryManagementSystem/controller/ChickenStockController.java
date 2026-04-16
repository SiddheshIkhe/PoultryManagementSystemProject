package com.example.poultryManagementSystem.controller;

import com.example.poultryManagementSystem.entity.ChickenStock;
import com.example.poultryManagementSystem.service.ChickenStockService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/chicken-stock")
@CrossOrigin(origins = "*")
public class ChickenStockController {

    private final ChickenStockService chickenStockService;

    public ChickenStockController(ChickenStockService chickenStockService) {
        this.chickenStockService = chickenStockService;
    }


    @PostMapping
    public ChickenStock save(@RequestBody ChickenStock chickenStock) {
        return chickenStockService.save(chickenStock);
    }


    @GetMapping("/{farmId}")
    public List<ChickenStock> getAllByFarm(@PathVariable Long farmId) {
        return chickenStockService.getAllByFarm(farmId);
    }

    @GetMapping("/{farmId}/date")
    public List<ChickenStock> getByDate(
            @PathVariable Long farmId,
            @RequestParam LocalDate date) {
        return chickenStockService.getByFarmAndDate(farmId, date);
    }

    @GetMapping("/{farmId}/filter")
    public List<ChickenStock> getByDateRange(
            @PathVariable Long farmId,
            @RequestParam LocalDate from,
            @RequestParam LocalDate to) {
        return chickenStockService.getByFarmAndDateRange(farmId, from, to);
    }



    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        chickenStockService.delete(id);
        return "Chicken stock deleted successfully";
    }
}