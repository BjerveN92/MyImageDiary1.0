package com.example.MyImageDiary10.DTOs.entryDTOs;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class EntryUpdateRequest {
    private String title;
    private String content;
    private MultipartFile entryImage;

}