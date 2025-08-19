package com.example.MyImageDiary10.DTOs.userDTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder // good to have, so i dont need to have all the variables when returning data in
         // service
@AllArgsConstructor
public class UserResponse {
    private String id;
    private String username;
    private String profileImageURL;

}
