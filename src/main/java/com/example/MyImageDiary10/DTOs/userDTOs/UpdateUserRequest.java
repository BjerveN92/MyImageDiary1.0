package com.example.MyImageDiary10.DTOs.userDTOs;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private String username;
    private String password;
    private String email;
    private MultipartFile profileImage;
}
