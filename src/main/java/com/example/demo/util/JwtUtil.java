package com.example.demo.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.SecretKey;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

//    private final long JWT_EXPIRATION = 1000 * 60 * 60 * 10; // 10 hours
    private final long JWT_EXPIRATION = Duration.ofMinutes(10).toMillis(); // 10 min

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(String username, long expiration) {
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSigningKey())
                .compact();
    }

    public String extractUsername(String token) {
        try {
            Claims claims = getClaims(token);
            return claims.getSubject();
        } catch (Exception e) {
            System.err.println("[JwtUtil] Failed to extract username: " + e.getMessage());
            return null;
        }
    }

    public boolean isTokenValid(String token, String username) {
        try {
            String extractedUsername = extractUsername(token);
            return extractedUsername != null &&
                    extractedUsername.equals(username) &&
                    !isTokenExpired(token);
        } catch (Exception e) {
            System.err.println("[JwtUtil] Token validation failed: " + e.getMessage());
            return false;
        }
    }

    public boolean isTokenExpired(String token) {
        try {
            Date expiration = getClaims(token).getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            System.err.println("[JwtUtil] Could not check token expiration: " + e.getMessage());
            return true; // fail-safe: treat invalid tokens as expired
        }
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public long getExpirationForUser(UserDetails user) {
        return JWT_EXPIRATION;
    }
}
