package com.example.MyImageDiary10.DTOs.entryDTOs;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntryRequest {
    private String title;
    private String content;
    private MultipartFile entryImage;
}
