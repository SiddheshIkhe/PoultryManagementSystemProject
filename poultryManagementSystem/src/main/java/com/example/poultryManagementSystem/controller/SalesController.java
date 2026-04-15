package com.example.poultryManagementSystem.controller;

import com.example.poultryManagementSystem.entity.Sales;
import com.example.poultryManagementSystem.service.SalesService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/sales")
@CrossOrigin(origins = "*")
public class SalesController {

    private final SalesService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    // ✅ CREATE (JWT auto farm OR old farmId)
    @PostMapping
    public Sales save(@RequestBody Sales sales) {
        return salesService.save(sales);
    }

    // =========================
    // 🔹 OLD APIs (KEEP)
    // =========================

    @GetMapping("/{farmId}")
    public List<Sales> getAllByFarm(@PathVariable Long farmId) {
        return salesService.getAllByFarm(farmId);
    }

    @GetMapping("/{farmId}/filter")
    public List<Sales> getByDateRange(
            @PathVariable Long farmId,
            @RequestParam LocalDate from,
            @RequestParam LocalDate to) {
        return salesService.getByFarmAndDateRange(farmId, from, to);
    }



    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        salesService.delete(id);
        return "Sales record deleted successfully";
    }
}