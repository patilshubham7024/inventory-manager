package com.shop.inventorymanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "sell_order")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "sellOrder", cascade = CascadeType.ALL)
    private List<Item> items;

    @Column(name = "total_amount")
    private Double totalAmount;

    private String customerName;

    private LocalDateTime orderDateTime;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @PrePersist
    public void setCreatedDate() {
        this.createdDate = LocalDateTime.now();
        if(orderDateTime == null) {
            orderDateTime = LocalDateTime.now();
        }
    }

    @PreUpdate
    public void setUpdatedDate() {
        this.updatedDate = LocalDateTime.now();
    }

}
