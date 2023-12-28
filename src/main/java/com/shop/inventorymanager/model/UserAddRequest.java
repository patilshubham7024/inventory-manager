package com.shop.inventorymanager.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAddRequest {
    private String name;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String role;
}
