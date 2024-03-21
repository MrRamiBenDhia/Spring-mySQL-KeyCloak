package com.minotore.Tools.jwt;


import java.util.List;

import javax.crypto.SecretKey;

import java.lang.reflect.Type;
import java.util.Date;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class jwtController {
    public static void main( String[] args ) throws Exception {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<String>>() {}.getType();
        String content = new String(Files.readAllBytes(Paths.get("/Users/mayankc/Work/source/perfComparisons/testdata/emails.json")));
        List<String> emails = gson.fromJson(content, listType);
        int i = 1, idx = 0;
        String jwtSecret = System.getenv("JWT_SECRET");
        int numIterations = Integer.parseInt(args[0]);
        long startTS = 0;
        SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes());

        while(true) {
            if (i == 10000) {
                startTS = System.currentTimeMillis();
            }
            String email = emails.get(idx);
            long currTS = System.currentTimeMillis();
            String jwt = Jwts.builder()
                    .issuedAt(new Date(currTS))
                    .expiration(new Date(currTS + 2 * 60 * 60 * 1000))
                    .subject(email)
                    .signWith(key)
                    .compact();
            Jws<Claims> claims = Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(jwt);
            if(!email.equals(claims.getPayload().getSubject())) {
                System.exit(1);
            }
            idx++;
            if (idx >= emails.size()) {
                idx = 0;
            }
            if (i++ > numIterations) {
                break;
            }
        }

        long endTS = System.currentTimeMillis();
        long diff = endTS - startTS;
        System.out.println(diff);
    }
}
