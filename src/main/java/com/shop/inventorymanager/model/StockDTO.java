package com.shop.inventorymanager.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockDTO {
    private String productCode;
    private Integer purchaseQuantity;
    private Integer soldQuantity;
}
