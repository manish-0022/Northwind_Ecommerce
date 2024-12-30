package com.Northwind.Ecommerce.security;

import com.Northwind.Ecommerce.entity.User;
import io.jsonwebtoken.Jwts;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
@Slf4j
public class JwtUtils {

    private static final long EXPIRATION_TIME_IN_MILLISEC = 1000L * 60L * 60L *24L *30L *6L ; //expire in 6 months

    private SecretKey key;

    @Value("$(secretJwtString)")
    private String secretJwtString;

    @PostConstruct
    private void init() {
        byte[] keyBytes = secretJwtString.getBytes(StandardCharsets.UTF_8);
        this.key = new SecretKeySpec(keyBytes, "HmacSHA256");
    }
    public String generateToken(User user){
        String username  = user.getEmail();
        return generateToken(username);
    }

    public String generateToken(String username){
      return Jwts.builder().setSubject(username).
              setIssuedAt(new Date(System.currentTimeMillis())).
              setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME_IN_MILLISEC))
              .signWith(key)
              .compact();
    }

    }







