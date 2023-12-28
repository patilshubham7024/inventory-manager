package com.shop.inventorymanager.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseAddRequest {
    private String productCode;
    private Integer quantity;
    private Double price;
}
