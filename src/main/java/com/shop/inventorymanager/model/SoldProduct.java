package com.shop.inventorymanager.model;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SoldProduct {
    @NotNull(message = "Product code is mandatory.")
    private String productCode;
    @NotNull(message = "Quantity is mandatory.")
    private Integer quantity;
    @NotNull(message = "Price is mandatory.")
    private Double price;
}
