package com.example.MyImageDiary10.services;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.MyImageDiary10.DTOs.entryDTOs.EntryRequest;
import com.example.MyImageDiary10.DTOs.entryDTOs.EntryResponse;
import com.example.MyImageDiary10.DTOs.entryDTOs.EntryResponseListItem;
import com.example.MyImageDiary10.DTOs.entryDTOs.EntryUpdateRequest;
import com.example.MyImageDiary10.models.Entry;
import com.example.MyImageDiary10.repositories.EntryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EntryService extends ObjectService<EntryResponse, EntryRequest, EntryUpdateRequest> {
    private final EntryRepository entryRepository;
    private final CloudinaryService cloudinaryService;
    // ==DEFAULT CRUD-OPERATIONS==

    // ===== CREATE =====
    @Override
    public EntryResponse create(EntryRequest newEntry) {
        MultipartFile entryImage = newEntry.getEntryImage();
        String imageURL = cloudinaryService.uploadEntryImage(entryImage);

        Entry entry = new Entry();
        entry.setTitle(newEntry.getTitle());
        entry.setContent(newEntry.getContent());
        entry.setCreatedAt(ZonedDateTime.now());
        entry.setEntryImageURL(imageURL);
        return null;
    }

    // ===== READ (ONE) =====
    @Override
    public EntryResponse getById(String id) {
        return entryRepository.findById(id)
                .map(entry -> EntryResponse.builder()
                        .id(entry.getId())
                        .title(entry.getTitle())
                        .content(entry.getContent())
                        .entryImageURL(entry.getEntryImageURL())
                        .createdAt(entry.getCreatedAt())
                        .build())
                .orElseThrow(() -> new RuntimeException("Entry not found"));

    }

    // ===== UPDATE =====
    @Override
    public EntryResponse update(String id, EntryUpdateRequest existingEntry) {
        return entryRepository.findById(id)
                .map(entry -> {
                    entry.setTitle(existingEntry.getTitle());
                    entry.setContent(existingEntry.getContent());

                    // Om en ny bild skickas med, ladda upp och uppdatera URL
                    if (existingEntry.getEntryImage() != null && !existingEntry.getEntryImage().isEmpty()) {
                        String imageUrl = cloudinaryService.uploadEntryImage(existingEntry.getEntryImage());
                        entry.setEntryImageURL(imageUrl);
                    }

                    entryRepository.save(entry);

                    return EntryResponse.builder()
                            .id(entry.getId())
                            .title(entry.getTitle())
                            .content(entry.getContent())
                            .entryImageURL(entry.getEntryImageURL())
                            .createdAt(entry.getCreatedAt())
                            .build();
                })
                .orElseThrow(() -> new RuntimeException("Entry not found"));
    }

    // ===== DELETE =====
    @Override
    public void delete(String id) {
        entryRepository.deleteById(id);
    }
    // ===== READ (ALL) (NON-DEFAULT-METHOD) =====

    public List<EntryResponseListItem> getAllEntries() {
        return entryRepository.findAll().stream()
                .map(entry -> EntryResponseListItem.builder()
                        .id(entry.getId())
                        .title(entry.getTitle())
                        .entryImageURL(entry.getEntryImageURL())
                        .createdAt(entry.getCreatedAt())
                        .build())
                .collect(Collectors.toList());
    }
}
