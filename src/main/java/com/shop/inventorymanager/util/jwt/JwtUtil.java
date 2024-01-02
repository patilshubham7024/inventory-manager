package com.shop.inventorymanager.util.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	private static final long TOKEN_VALIDITY = 12 * 60 * 60;

	private final String JWT_SECRET = "VFb0qJ1LRg4ujbZoRMXnVkUgiuKq5KxWqNdbKqG9VvzS1zZa9LPxtHWKa64zDl2ofkT8F6jBtK4riUfPgsssssss";

//	Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);


	public String generateJwtToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
//		Key k = Keys.builder(Keys.hmacShaKeyFor(JWT_SECRET.getBytes())).build();
//		SecretKey k = generateSecretKey();
//		String jwtToken = Jwts.builder().subject(userDetails.getUsername())
//				.signWith(SignatureAlgorithm.forSigningKey(k), k.getAlgorithm())
//				.compact();
//		Jws<Claims> jwsClaims = Jwts.parser()
//				.verifyWith(k)
//				.build()
//				.parseSignedClaims(jwtToken);
//		Claims payload = jwsClaims.getPayload();


//		return Jwts.builder()
//				.claims(claims)
//				.subject(userDetails.getUsername())
//				.issuedAt(new Date(System.currentTimeMillis()))
//				.expiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000))
//				.signWith(k)
//				.claim("ROLE","ADMIN")
//				.compact();
		return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, JWT_SECRET)
				.claim("ROLE","ADMIN").compact();
	}

	public Boolean validateJwtToken(String token, UserDetails userDetails) {
		String username = getUsernameFromToken(token);
		Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
		Boolean isTokenExpired = claims.getExpiration().before(new Date());
		System.out.println(isTokenExpired);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired);
	}

	public String getUsernameFromToken(String token) {
		final Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}

//	public String getUsernameFromToken(String token) {
//		SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(JWT_SECRET));
//		return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getSignature();
//	}















//
//	private static SecretKey generateSecretKey() {
//		// You can adjust the key size based on your security requirements
//		int keySize = 1024;
//
//		// Generate a random secret key
//		SecureRandom secureRandom = new SecureRandom();
//		byte[] keyBytes = new byte[keySize];
//		secureRandom.nextBytes(keyBytes);
//
//		// Convert the byte array to a Base64-encoded string
//		String base64Encoded = Base64.getEncoder().encodeToString(keyBytes);
//
//		// Create a SecretKey from the Base64-encoded string
//		return new SecretKeySpec(Base64.getDecoder().decode(base64Encoded), Jwts.SIG.HS512.toString());
//	}

//	public String extractUsername(String token) {
//		return extractClaim(token, Claims::getSubject);
//	}
//
//	public Date extractExpiration(String token) {
//		return extractClaim(token, Claims::getExpiration);
//	}
//
//	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//		final Claims claims = extractAllClaims(token);
//		return claimsResolver.apply(claims);
//	}
//
//	public Claims extractAllClaims(String token) {
//		return Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
//	}
//
//	public Boolean isTokenExpired(String token) {
//		return extractExpiration(token).before(new Date());
//	}
//
//	public String generateToken(UserDetails userDetails) {
//		Map<String, Object> claims = new HashMap<>();
//		return createToken(claims, userDetails.getUsername());
//	}
//
//	public String createToken(Map<String, Object> claims, String subject) {
//		return Jwts.builder()
//				.setClaims(claims)
//				.setSubject(subject)
//				.setIssuedAt(new Date(System.currentTimeMillis()))
//				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
//				.signWith(SignatureAlgorithm.HS256, JWT_SECRET).compact();
//	}
//
//	public Boolean validateToken(String token, UserDetails userDetails) {
//		final String userName = extractUsername(token);
//		return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
//	}
}