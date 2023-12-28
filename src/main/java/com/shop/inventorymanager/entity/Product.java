package com.shop.inventorymanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "product")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "sell_price")
    private Double sellPrice;

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
