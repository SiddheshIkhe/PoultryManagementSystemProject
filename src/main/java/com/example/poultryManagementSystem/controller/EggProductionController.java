package com.example.poultryManagementSystem.controller;

import com.example.poultryManagementSystem.entity.EggProduction;
import com.example.poultryManagementSystem.service.EggProductionService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/egg-production")
@CrossOrigin(origins = "*")
public class EggProductionController {

    private final EggProductionService eggProductionService;

    public EggProductionController(EggProductionService eggProductionService) {
        this.eggProductionService = eggProductionService;
    }

    // ✅ CREATE (JWT auto farm OR old farmId)
    @PostMapping
    public EggProduction save(@RequestBody EggProduction eggProduction) {
        return eggProductionService.save(eggProduction);
    }

    // =========================
    // 🔹 OLD APIs (KEEP)
    // =========================

    @GetMapping("/{farmId}")
    public List<EggProduction> getAllByFarm(@PathVariable Long farmId) {
        return eggProductionService.getAllByFarm(farmId);
    }

    @GetMapping("/{farmId}/filter")
    public List<EggProduction> getByDateRange(
            @PathVariable Long farmId,
            @RequestParam LocalDate from,
            @RequestParam LocalDate to) {
        return eggProductionService.getByFarmAndDateRange(farmId, from, to);
    }



    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        eggProductionService.delete(id);
        return "Egg production record deleted successfully";
    }
}