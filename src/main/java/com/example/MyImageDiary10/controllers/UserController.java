package com.example.MyImageDiary10.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyImageDiary10.DTOs.userDTOs.LoginRequest;
import com.example.MyImageDiary10.DTOs.userDTOs.RegisterRequest;
import com.example.MyImageDiary10.DTOs.userDTOs.UpdateUserRequest;
import com.example.MyImageDiary10.DTOs.userDTOs.UserResponse;
import com.example.MyImageDiary10.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // ===============Register user===============
    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@ModelAttribute RegisterRequest request) {
        return ResponseEntity.ok(userService.create(request));
    }

    // ===============Login user===============
    @PostMapping("/login")
    public ResponseEntity<UserResponse> loginUser(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.login(loginRequest));
    }

    // ===============Get user by id===============
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    // ===============Update user===============
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable String id,
            @ModelAttribute UpdateUserRequest request) {
        return ResponseEntity.ok(userService.update(id, request));
    }

    // ===============Delete user===============
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
