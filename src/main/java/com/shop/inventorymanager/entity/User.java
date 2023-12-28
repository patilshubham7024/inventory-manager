package com.shop.inventorymanager.entity;

import lombok.*;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "user")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @PrePersist
    public void setCreatedDate() {
        this.createdDate = LocalDateTime.now();
    }

    @PreUpdate
    public void setUpdatedDate() {
        this.updatedDate = LocalDateTime.now();
    }

}
