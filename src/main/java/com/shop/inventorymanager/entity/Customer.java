package com.shop.inventorymanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "customer")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    private LocalDateTime createdDate;
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
