package com.example.UberAuthService.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class JWTService implements CommandLineRunner {

    @Value("${jwt.expiry}")
    private int expiry;

    @Value(("${jwt.secret}"))
    private String SECRET;

    public String generateJWTToken(Map<String, Object> payload, String username) {
        SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes());

        return Jwts.builder()
                .setClaims(payload)                   // Custom payload data (like roles, id)
                .setSubject(username)                // Main identity info (username/email)
                .setIssuedAt(new Date())             // Current time
                .setExpiration(new Date(System.currentTimeMillis() + expiry)) // Expiration
                .signWith(SignatureAlgorithm.HS256, key) // Sign with key + algorithm
                .compact();                          // Generate token
    }

    @Override
    public void run(String... args) throws Exception {
        Map<String,Object> mp=new HashMap<>();
        mp.put("email","abc@gmail.com");
        mp.put("phone","999999");
        String result=generateJWTToken(mp,"adnan");
        System.out.println("Generated id is: "+result);
    }
}
