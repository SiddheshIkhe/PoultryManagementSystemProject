package com.example.poultryManagementSystem.service;

import com.example.poultryManagementSystem.entity.EggProduction;

import com.example.poultryManagementSystem.repository.EggProductionRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EggProductionService {

    private final EggProductionRepo eggProductionRepo;



    public EggProductionService(EggProductionRepo eggProductionRepository) {
        this.eggProductionRepo = eggProductionRepository;
    }

    // ✅ UPDATED SAVE (JWT + fallback)
    public EggProduction save(EggProduction eggProduction) {
        if (eggProductionRepo.existsByFarm_IdAndDate(
                eggProduction.getFarm().getId(),
                eggProduction.getDate()
        )) {
            throw new RuntimeException("Duplicate entry");
        }
        return eggProductionRepo.save(eggProduction);
    }

    // ✅ OLD API (keep working)
    public List<EggProduction> getAllByFarm(Long farmId) {
        return eggProductionRepo.findByFarm_Id(farmId);
    }


    // ✅ OLD API
    public List<EggProduction> getByFarmAndDateRange(Long farmId, LocalDate from, LocalDate to) {
        return eggProductionRepo.findByFarm_IdAndDateBetween(farmId, from, to);
    }



    public void delete(Long id) {
        eggProductionRepo.deleteById(id);
    }
}