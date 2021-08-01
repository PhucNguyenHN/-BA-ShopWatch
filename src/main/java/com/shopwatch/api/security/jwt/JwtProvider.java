package com.shopwatch.api.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.java.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.shopwatch.api.entity.User;
import com.shopwatch.api.repository.UserRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
@Log
public class JwtProvider {

    @Value("$(jwt.secret)")
    private String jwtSecret;
    
    @Autowired
    UserRepository userRepository;

    //Tao Token Từ 1 
    public String generateToken(String email) {
    	Date now = new Date();
//    	Thoi gian tinh bang milisecond 
    	final long JWT_EXPIRATION = 86400000L;
    	Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
        User user = userRepository.findByEmail(email);
        return Jwts.builder().claim("User",user)
                .setSubject(user.getEmail())
//                set Time het han
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            log.severe("invalid token");
        }
        return false;
    }

    public String getUsenameFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
       
        return claims.getSubject();
    }
}
