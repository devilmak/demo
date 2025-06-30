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
    private final long JWT_EXPIRATION = Duration.ofMinutes(1).toMillis(); // 1 min

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
        return getClaims(token).getSubject();
    }

    public boolean isTokenValid(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    public boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public long getExpirationForUser(UserDetails user) {
//        boolean isAdmin = user.getAuthorities().stream()
//                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
//
//        return isAdmin ? Duration.ofHours(24).toMillis() : Duration.ofHours(10).toMillis();
        return JWT_EXPIRATION;
    }
}
