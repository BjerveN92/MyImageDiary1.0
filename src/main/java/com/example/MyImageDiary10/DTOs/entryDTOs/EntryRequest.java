package com.example.MyImageDiary10.DTOs.entryDTOs;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntryRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotBlank
    private MultipartFile entryImage;
}
