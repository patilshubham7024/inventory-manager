package com.shop.inventorymanager.filter;

import java.io.IOException;

import com.shop.inventorymanager.model.security.UserLoginDetails;
import com.shop.inventorymanager.service.security.UserLoginDetailsService;
import com.shop.inventorymanager.util.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtils;

	@Autowired
	private UserLoginDetailsService userLoginDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String auth = request.getHeader("Authorization");
		String token;
		String username = null;
		if (auth != null && auth.startsWith("Bearer")) {
			token = auth.substring(6);
			username = jwtUtils.getUsernameFromToken(token);
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserLoginDetails currentUser = (UserLoginDetails) userLoginDetailsService.loadUserByUsername(username);

			UsernamePasswordAuthenticationToken userAuthToken = new UsernamePasswordAuthenticationToken(currentUser,
					null, currentUser.getAuthorities());
			userAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(userAuthToken);
		}

		filterChain.doFilter(request, response);

	}

}

