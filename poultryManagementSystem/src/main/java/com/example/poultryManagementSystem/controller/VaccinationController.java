package com.example.poultryManagementSystem.controller;

import com.example.poultryManagementSystem.entity.Vaccination;
import com.example.poultryManagementSystem.service.VaccinationService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/vaccination")
@CrossOrigin(origins = "*")
public class VaccinationController {

    private final VaccinationService vaccinationService;

    public VaccinationController(VaccinationService vaccinationService) {
        this.vaccinationService = vaccinationService;
    }

    // ✅ CREATE (JWT auto farm OR old farmId)
    @PostMapping
    public Vaccination save(@RequestBody Vaccination vaccination) {
        return vaccinationService.save(vaccination);
    }

    // =========================
    // 🔹 OLD APIs (KEEP)
    // =========================

    @GetMapping("/{farmId}")
    public List<Vaccination> getAllByFarm(@PathVariable Long farmId) {
        return vaccinationService.getAllByFarm(farmId);
    }

    @GetMapping("/{farmId}/filter")
    public List<Vaccination> getByDateRange(
            @PathVariable Long farmId,
            @RequestParam LocalDate from,
            @RequestParam LocalDate to) {
        return vaccinationService.getByFarmAndDateRange(farmId, from, to);
    }



    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        vaccinationService.delete(id);
        return "Vaccination record deleted successfully";
    }
}