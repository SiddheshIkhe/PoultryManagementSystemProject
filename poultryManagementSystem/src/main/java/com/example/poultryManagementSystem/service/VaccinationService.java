package com.example.poultryManagementSystem.service;

import com.example.poultryManagementSystem.entity.Vaccination;
import com.example.poultryManagementSystem.repository.VaccinationRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VaccinationService {

    private final VaccinationRepo vaccinationRepo;



    public VaccinationService(VaccinationRepo vaccinationRepository) {
        this.vaccinationRepo = vaccinationRepository;
    }

    // ✅ UPDATED SAVE (JWT + fallback)
    public Vaccination save(Vaccination vaccination) {

        return vaccinationRepo.save(vaccination);
    }

    // ✅ OLD API (keep working)
    public List<Vaccination> getAllByFarm(Long farmId) {
        return vaccinationRepo.findByFarm_Id(farmId);
    }

    // ✅ OLD API
    public List<Vaccination> getByFarmAndDateRange(Long farmId, LocalDate from, LocalDate to) {
        return vaccinationRepo.findByFarm_IdAndDateBetween(farmId, from, to);
    }

    public void delete(Long id) {
        vaccinationRepo.deleteById(id);
    }
}