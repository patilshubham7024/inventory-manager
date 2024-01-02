package com.shop.inventorymanager.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SoldProductDTO {
    private String product;
    private Integer quantity;
    private Double price;
}
