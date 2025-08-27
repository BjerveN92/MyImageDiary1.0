package com.example.MyImageDiary10.services;

import org.springframework.stereotype.Service;

import com.example.MyImageDiary10.DTOs.userDTOs.RegisterRequest;
import com.example.MyImageDiary10.DTOs.userDTOs.UpdateUserRequest;
import com.example.MyImageDiary10.DTOs.userDTOs.UserResponse;
import com.example.MyImageDiary10.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService extends ObjectService<UserResponse, RegisterRequest, UpdateUserRequest> {
    private final UserRepository userRepository;
    private final CloudinaryService cloudinaryService;

    // create a user (REGISTER)
    @Override
    public UserResponse create(RegisterRequest newUser) {
        return null;
    }

    // read one user by ID
    @Override
    public UserResponse getById(String id) {
        return userRepository.findById(id)
                .map(user -> UserResponse.builder()
                        .id(user.getId())
                        .username(user.getUsername())
                        .profileImageURL(user.getProfileImageURL())
                        .build())
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // update the user by Id
    @Override
    public UserResponse update(String id, UpdateUserRequest existingUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(existingUser.getUsername());
                    if (existingUser.getProfileImage() != null && !existingUser.getProfileImage().isEmpty()) {
                        // uploads image to cloudinary, yeeey!
                        String imageUrl = cloudinaryService.uploadImage(existingUser.getProfileImage());
                        user.setProfileImageURL(imageUrl);
                    }
                    userRepository.save(user);
                    return UserResponse.builder()
                            .id(user.getId())
                            .username(user.getUsername())
                            .profileImageURL(user.getProfileImageURL())
                            .build();
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // delete one user
    @Override
    public void delete(String id) {
    }
}
