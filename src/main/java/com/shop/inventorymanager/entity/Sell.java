//package com.shop.inventorymanager.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Table(name = "sell")
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class Sell {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToMany
//    @JoinColumn(name = "productId")
//    private List<Product> product;
//
//    @ManyToOne
//    @JoinColumn(name = "userId")
//    private User user;
//
//    private String customerName;
//
//    private Double sellAmount;
//
//    private LocalDateTime sellDateTime;
//    private LocalDateTime createdDate;
//    private LocalDateTime updatedDate;
//
//    @PrePersist
//    public void setCreatedDate() {
//        this.createdDate = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    public void setUpdatedDate() {
//        this.updatedDate = LocalDateTime.now();
//    }
//}
