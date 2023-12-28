package com.shop.inventorymanager.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellDTO {
    private String product;
    private Integer quantity;
    private Double price;
}
