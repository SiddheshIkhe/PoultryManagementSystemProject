package com.example.poultryManagementSystem.service;

import com.example.poultryManagementSystem.DTO.LoginResponse;
import com.example.poultryManagementSystem.entity.Farm;
import com.example.poultryManagementSystem.entity.User;
import com.example.poultryManagementSystem.repository.FarmRepo;
import com.example.poultryManagementSystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private FarmRepo farmRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



// ✅ CREATE USER
 public User createUser(Long farmId, User user) {
     Farm farm = farmRepository.findById(farmId)
        .orElseThrow(() -> new RuntimeException("Farm not found"));
     user.setFarm(farm);
     return userRepository.save(user);
 }
// ✅ LOGIN USER
 public LoginResponse login(String username, String password) {
     User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new RuntimeException("User not found"));
     if (!user.getPassword().equals(password)) {
         throw new RuntimeException("Invalid password");
     }
     LoginResponse res = new LoginResponse();
     res.setId(user.getId());
     res.setUsername(user.getUsername());
     res.setRole(user.getRole());
     if (user.getFarm() != null) {
        res.setFarmId(user.getFarm().getId());
     }
     return res;
 }
}