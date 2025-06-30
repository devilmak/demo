package com.example.demo.auth.dto;

import lombok.Data;

@Data
public class AuthResponseDto {

    private String token;

    private long expiresIn; // in milliseconds

    public AuthResponseDto(String token, long expiresIn) {
        this.token = token;
        this.expiresIn = expiresIn;
    }
}
