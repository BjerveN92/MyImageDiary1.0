package com.example.MyImageDiary10.DTOs.entryDTOs;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntryResponse {
    private String id;
    private String title;
    private String content;
    private String entryImageURL;
    private LocalDate createdAt;
}
