package com.example.MyImageDiary10.services;

import org.springframework.stereotype.Service;

import com.example.MyImageDiary10.DTOs.userDTOs.UserResponse;
import com.example.MyImageDiary10.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService extends ObjectService<UserResponse> {
    private final UserRepository userRepository;

    // create a user (REGISTER)
    @Override
    public UserResponse create(UserResponse newUser) {
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
    public UserResponse update(String id, UserResponse existingUser) {
        return userRepository.findById(id)
                .map(user -> {
                    // Update userfileds
                    user.setUsername(existingUser.getUsername());
                    user.setProfileImageURL(existingUser.getProfileImageURL());
                    // Save the updated user
                    userRepository.save(user);

                    // Return the updated user
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
