package com.shop.inventorymanager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Table(name = "sell")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    private Double salePrice;
    private Integer saleQuantity;
    private Date saleDate;
}
