package com.example.MyImageDiary10.DTOs.userDTOs;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String email;
    private MultipartFile profileImage; // this can also have a separate upload endpoint if this is not needed when
    // register
}
