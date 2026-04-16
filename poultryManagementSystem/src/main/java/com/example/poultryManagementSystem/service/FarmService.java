package com.example.poultryManagementSystem.service;

import com.example.poultryManagementSystem.entity.Farm;

import com.example.poultryManagementSystem.repository.FarmRepo;
import com.example.poultryManagementSystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmService {

    @Autowired
    private FarmRepo farmRepo;

    @Autowired
    private UserRepo userRepo;


    // ✅ CREATE FARM + ASSIGN TO LOGGED-IN USER
    public Farm saveFarm(Farm farm) {
        if (farmRepo.existsByName(farm.getName())) {
            throw new RuntimeException("Farm already exists");
        }
        return farmRepo.save(farm);
    }

    // ✅ GET ALL FARMS (ADMIN USE)
    public List<Farm> getAllFarms() {
        return farmRepo.findAll();
    }

    // ✅ DELETE FARM
    public void delete(Long id) {
        farmRepo.deleteById(id);
    }
}