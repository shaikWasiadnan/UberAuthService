package com.example.UberAuthService.services;

import io.jsonwebtoken.*;
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

    private SecretKey key;

    public String generateJWTToken(Map<String, Object> payload, String email) {
        key = Keys.hmacShaKeyFor(SECRET.getBytes());

        return Jwts.builder()
                .setClaims(payload)                   // Custom payload data (like roles, id)
                .setSubject(email)                // Main identity info (username/email)
                .setIssuedAt(new Date())             // Current time
                .setExpiration(new Date(System.currentTimeMillis() + expiry)) // Expiration
                .signWith(SignatureAlgorithm.HS256, key) // Sign with key + algorithm
                .compact();                          // Generate token
    }


    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token); // Will throw exception if invalid
            return true;
        } catch (ExpiredJwtException e) {
            System.out.println("Token expired");
        } catch (UnsupportedJwtException e) {
            System.out.println("Unsupported JWT");
        } catch (MalformedJwtException e) {
            System.out.println("Malformed JWT");
        } catch (SignatureException e) {
            System.out.println("Invalid signature");
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal argument");
        }
        return false;
    }


    public String emailAddress(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    @Override
    public void run(String... args) throws Exception {
        Map<String,Object> mp=new HashMap<>();
        mp.put("email","abc@gmail.com");
        mp.put("phone","999999");
        String result=generateJWTToken(mp,"adnan");
        System.out.println("Generated id is: "+result);
        System.out.println("valiid? : "+validateToken(result));
    }
}
