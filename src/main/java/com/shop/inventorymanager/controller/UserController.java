package com.shop.inventorymanager.controller;

import com.shop.inventorymanager.entity.User;
import com.shop.inventorymanager.model.UserAddRequest;
import com.shop.inventorymanager.model.UserAddResponse;
import com.shop.inventorymanager.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.shop.inventorymanager.constant.Messages.USER_ADD_ERROR;
import static com.shop.inventorymanager.constant.Messages.USER_ADD_SUCCESS;

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
    public UserAddResponse add(@RequestBody UserAddRequest addRequest) {
        User added = userService.add(addRequest);
        if(added != null) {
            return UserAddResponse.builder().message(USER_ADD_SUCCESS).userName(added.getUsername()).build();
        }
        return UserAddResponse.builder().message(USER_ADD_ERROR).build();
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
