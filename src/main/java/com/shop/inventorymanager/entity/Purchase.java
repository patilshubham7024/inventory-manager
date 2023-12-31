package com.shop.inventorymanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "purchase")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private Double purchasePrice;
    private Integer purchaseQuantity;
    private Date purchaseDate;

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
