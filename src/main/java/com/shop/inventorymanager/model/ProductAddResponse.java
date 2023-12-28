package com.shop.inventorymanager.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductAddResponse {
    private String message;
    private String code;
}
