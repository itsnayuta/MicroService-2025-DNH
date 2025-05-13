package com.example.service_question.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Date;

public class JWTUtils {


    private static final String SECRET_KEY = "onlinetestingcode";  // Secret key của bạn


    private static Key getSigningKey() {
        try {

            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] keyBytes = digest.digest(SECRET_KEY.getBytes(StandardCharsets.UTF_8));


            return new javax.crypto.spec.SecretKeySpec(keyBytes, SignatureAlgorithm.HS256.getJcaName());
        } catch (Exception e) {
            throw new RuntimeException("Error while generating signing key", e);
        }
    }

    public static String generateToken(String username, String role) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)  // role
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))  // 1h
                .signWith(getSigningKey())
                .compact();
    }

    @SuppressWarnings("deprecation")
    public static String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(getSigningKey())  // giải mã
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    @SuppressWarnings("deprecation")
    public static String extractRole(String token) {
        return (String) Jwts.parser()
                .setSigningKey(getSigningKey())
                .parseClaimsJws(token)
                .getBody()
                .get("role");
    }

    public static boolean isTokenExpired(String token) {
        @SuppressWarnings("deprecation")
        Date expiration = Jwts.parser()
                .setSigningKey(getSigningKey())
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expiration.before(new Date());
    }


    public static boolean isTokenValid(String token) {


        if(token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);

            return  !isTokenExpired(token);
        }

        return false;
    }
}
