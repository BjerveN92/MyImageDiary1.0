package com.example.MyImageDiary10.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyImageDiary10.DTOs.entryDTOs.EntryRequest;
import com.example.MyImageDiary10.DTOs.entryDTOs.EntryResponse;
import com.example.MyImageDiary10.DTOs.entryDTOs.EntryResponseListItem;
import com.example.MyImageDiary10.DTOs.entryDTOs.EntryUpdateRequest;
import com.example.MyImageDiary10.services.EntryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/entry")
@RequiredArgsConstructor
public class EntryController {

    private final EntryService entryService;

    // ===============create new entry====================
    @PostMapping("/newEntry")
    public ResponseEntity<EntryResponse> newEntry(@ModelAttribute EntryRequest request) {
        return ResponseEntity.ok(entryService.create(request));
    }

    // ===============read one entry by id====================
    @GetMapping("/{id}")
    public ResponseEntity<EntryResponse> getEntryById(@PathVariable String id) {
        return ResponseEntity.ok(entryService.getById(id));
    }

    // ===============read all entries====================
    @GetMapping("/allEntries")
    public List<EntryResponseListItem> getAllEntries() {
        return entryService.getAllEntries();
    }

    // ===============update entry====================
    @PutMapping("/{id}")
    public ResponseEntity<EntryResponse> updateEntry(
            @PathVariable String id,
            @RequestBody EntryUpdateRequest request) {
        return ResponseEntity.ok(entryService.update(id, request));
    }

    // ===============delete entry====================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable String id) {
        entryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
