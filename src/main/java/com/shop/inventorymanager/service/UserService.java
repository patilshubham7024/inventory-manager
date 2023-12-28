package com.shop.inventorymanager.service;

import com.shop.inventorymanager.entity.User;
import com.shop.inventorymanager.model.UserAddRequest;
import com.shop.inventorymanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void get() {

    }

    public User add(UserAddRequest addRequest) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(addRequest.getPassword());

        return userRepository.save(User.builder()
                .username(addRequest.getUsername())
                .role(addRequest.getRole())
                .firstName(addRequest.getFirstName())
                .lastName(addRequest.getLastName())
                .password(encodedPassword)
                .build());
    }

    public void update() {

    }

    public void delete() {

    }
}
