package com.example.MyImageDiary10.DTOs.userDTOs;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
