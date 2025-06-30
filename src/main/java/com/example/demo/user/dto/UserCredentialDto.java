package com.example.demo.user.dto;

import com.example.demo.user.entity.UserCredential;
import lombok.Data;

@Data
public class UserCredentialDto {

    private String id;

    private String username;

    private String password;


    public void mapToDto(UserCredential userCredential) {
        this.setId(userCredential.getId());
        this.setPassword(userCredential.getPassword());
    }

}
