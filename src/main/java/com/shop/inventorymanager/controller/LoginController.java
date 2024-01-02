package com.shop.inventorymanager.controller;

import com.shop.inventorymanager.model.LoginRequest;
import com.shop.inventorymanager.model.LoginResponse;
import com.shop.inventorymanager.model.security.UserLoginDetails;
import com.shop.inventorymanager.service.security.UserLoginDetailsService;
import com.shop.inventorymanager.util.jwt.JwtUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@Log4j2
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserLoginDetailsService userLoginDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping
    public String test(){
        log.info("-----------------");
        return "Ok";
    }

    @PostMapping
    public LoginResponse authenticate(@RequestBody LoginRequest request) {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            if(authentication.isAuthenticated()) {
                UserLoginDetails userLoginDetails = (UserLoginDetails) userLoginDetailsService.loadUserByUsername(request.getUsername());
                String token= jwtUtil.generateJwtToken(userLoginDetails);
                return LoginResponse.builder().token(token).build();
            }else {
                throw new RuntimeException("Authentication Failed");
            }
    }
}
