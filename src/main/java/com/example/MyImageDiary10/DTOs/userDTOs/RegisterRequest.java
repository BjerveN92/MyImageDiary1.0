package com.example.MyImageDiary10.DTOs.userDTOs;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
    @NotBlank
    private MultipartFile profileImage; // this can also have a separate upload endpoint if this is not needed when
    // register
}
