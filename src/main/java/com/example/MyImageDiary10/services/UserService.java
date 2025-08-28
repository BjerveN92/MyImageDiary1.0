package com.example.MyImageDiary10.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.MyImageDiary10.DTOs.userDTOs.LoginRequest;
import com.example.MyImageDiary10.DTOs.userDTOs.RegisterRequest;
import com.example.MyImageDiary10.DTOs.userDTOs.UpdateUserRequest;
import com.example.MyImageDiary10.DTOs.userDTOs.UserResponse;
import com.example.MyImageDiary10.models.User;
import com.example.MyImageDiary10.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService extends ObjectService<UserResponse, RegisterRequest, UpdateUserRequest> {
    private final UserRepository userRepository;
    private final CloudinaryService cloudinaryService;
    private final BCryptPasswordEncoder passwordEncoder;

    // ===== CREATE (REGISTER) =====

    @Override
    public UserResponse create(RegisterRequest newUser) {

        MultipartFile profileImage = newUser.getProfileImage();
        String imageURL = cloudinaryService.uploadProfileImage(profileImage);
        // creates new user
        User user = new User();
        user.setUsername(newUser.getUsername());
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        user.setEmail(newUser.getEmail());
        user.setProfileImageURL(imageURL);

        userRepository.save(user);

        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .profileImageURL(user.getProfileImageURL())
                .build();
    }

    // ===== READ (ONE) =====

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

    // ===== UPDATE =====

    @Override
    public UserResponse update(String id, UpdateUserRequest existingUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(existingUser.getUsername());

                    if (existingUser.getProfileImage() != null && !existingUser.getProfileImage().isEmpty()) {
                        // uploads image to cloudinary, yeeey!
                        String imageUrl = cloudinaryService.uploadProfileImage(existingUser.getProfileImage());
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

    // ===== DELETE =====

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }
    // ===== LOGIN USER (NON_DEFAULT_METHOD) =====

    public UserResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("Wrong username or password"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Wrong username or password");
        }
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .profileImageURL(user.getProfileImageURL())
                .build();
    }

}