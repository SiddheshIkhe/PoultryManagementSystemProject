package com.example.poultryManagementSystem.controller;

import com.example.poultryManagementSystem.entity.Farm;
import com.example.poultryManagementSystem.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/farms")
@CrossOrigin(origins = "*")
public class FarmController {

    @Autowired
    private FarmService farmService;

    // ✅ CREATE FARM (auto assign to logged-in user)
    @PostMapping
    public Farm createFarm(@RequestBody Farm farm) {
        return farmService.saveFarm(farm);
    }



    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        farmService.delete(id);
        return "Farm deleted successfully";
    }
}