package com.shop.inventorymanager.controller;

import com.shop.inventorymanager.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Log4j2
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public void get() {
        userService.get();
    }

    @PostMapping
    public void add() {
        userService.add();
    }

    @PutMapping
    public void update() {
        userService.update();
    }

    @DeleteMapping
    public void delete() {
        userService.delete();
    }


}
