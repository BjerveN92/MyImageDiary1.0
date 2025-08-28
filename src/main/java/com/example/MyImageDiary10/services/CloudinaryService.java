package com.example.MyImageDiary10.services;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CloudinaryService {

    private final Cloudinary cloudinary;

    public String uploadProfileImage(MultipartFile profileImage) {
        try {
            Map uploadResult = cloudinary.uploader().upload(
                    profileImage.getBytes(),
                    ObjectUtils.asMap(
                            "resource_type", "auto",
                            "folder", "user-profile-images"));
            return uploadResult.get("secure_url").toString();
        } catch (IOException e) {
            // Log the exception or handle it as needed
            throw new RuntimeException("Failed to upload image.", e);
        }
    }

    public String uploadEntryImage(MultipartFile entryImage) {
        try {
            Map uploadResult = cloudinary.uploader().upload(
                    entryImage.getBytes(),
                    ObjectUtils.asMap(
                            "resource_type", "auto",
                            "folder", "user-entry-images"));
            return uploadResult.get("secure_url").toString();
        } catch (IOException e) {
            // Log the exception or handle it as needed
            throw new RuntimeException("Failed to upload image.", e);
        }
    }

}