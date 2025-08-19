package com.example.MyImageDiary10.models;

import java.time.LocalDate;

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
    private LocalDate createdAt; // This will be handeled by Json formatter later on when decided what format i
                                 // will use

    private String userId; // refering to the user-model
}
