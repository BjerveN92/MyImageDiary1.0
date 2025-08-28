package com.example.MyImageDiary10.models;

import java.time.ZonedDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "entries")
public class Entry {
    @Id
    private String id;

    private String title;
    private String content;
    private String entryImageURL;
    private ZonedDateTime createdAt;

    private String userId; // refering to the user-model
}
