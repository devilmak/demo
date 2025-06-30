package com.example.demo.auth.controller;

import com.example.demo.auth.dto.AuthRequestDto;
import com.example.demo.auth.dto.AuthResponseDto;
import com.example.demo.config.ApiResponse;
import com.example.demo.util.JwtUtil;
import com.example.demo.util.ResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequestDto request, HttpServletRequest httpRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getUsername(), request.getPassword()));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Invalid username or password"));
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());

        long expirationMillis = jwtUtil.getExpirationForUser(userDetails);

        final String token = jwtUtil.generateToken(userDetails.getUsername(), expirationMillis);

        return ResponseEntity.ok(new AuthResponseDto(token, expirationMillis));
    }
}
