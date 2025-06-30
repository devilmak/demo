package com.example.demo.user.dto;

import com.example.demo.user.entity.UserProfile;
import lombok.Data;

@Data
public class UserProfileDto {

    private String id;

    private String name;

    private String email;

    private String phone;


    public void mapToDto(UserProfile userProfile) {
        this.setId(userProfile.getId());
        this.setName(userProfile.getName());
        this.setPhone(userProfile.getPhone());
        this.setEmail(userProfile.getEmail());
    }

    public void mapToDto(UserAccountDto userAccountDto) {
        this.setName(userAccountDto.getName());
        this.setPhone(userAccountDto.getPhone());
        this.setEmail(userAccountDto.getEmail());
    }

}
