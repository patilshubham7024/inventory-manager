package com.shop.inventorymanager.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseDTO {
    private String productName;
    private Double purchasePrice;
    private Integer purchaseQuantity;
}
