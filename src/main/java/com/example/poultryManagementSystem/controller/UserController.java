package com.example.poultryManagementSystem.controller;

import com.example.poultryManagementSystem.DTO.LoginRequest;
import com.example.poultryManagementSystem.DTO.LoginResponse;
import com.example.poultryManagementSystem.entity.User;
import com.example.poultryManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;


    // =========================
    // 🔹 OPTIONAL (OLD API - KEEP)
    // =========================

    @PostMapping("/create/{farmId}")
    public User createUser(@PathVariable Long farmId, @RequestBody User user) {
        return userService.createUser(farmId, user);
    }

    // =========================
    // 🔹 LOGIN (JWT)
    // =========================

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return userService.login(
                request.getUsername(),
                request.getPassword()
        );
    }
}