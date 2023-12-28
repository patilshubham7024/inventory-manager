package com.shop.inventorymanager.util.jwt;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;

@Component
public class JwtUtil implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	private static final long TOKEN_VALIDITY = 12 * 60 * 60;

	private final String JWT_SECRET = "VFb0qJ1LRg4ujbZoRMXnVkUgiuKq5KxWqNdbKqG9VvzS1zZa9LPxtHWKa64zDl2ofkT8F6jBtK4riUfPgsssssss";

	public String generateJwtToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, JWT_SECRET).claim("ROLE","ADMIN").compact();
	}

	public Boolean validateJwtToken(String token, UserDetails userDetails) {
		String username = getUsernameFromToken(token);
		Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).build().parseEncryptedClaims(token).getBody();
		Boolean isTokenExpired = claims.getExpiration().before(new Date());
		System.out.println(isTokenExpired);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired);
	}

	public String getUsernameFromToken(String token) {
		SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(JWT_SECRET));
		return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getSignature();
//		return claims.getSubject();
	}
}
