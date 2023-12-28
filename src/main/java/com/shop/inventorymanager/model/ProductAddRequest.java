package com.shop.inventorymanager.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductAddRequest {
    private String name;
    private String code;
    private Double sellPrice;
}
