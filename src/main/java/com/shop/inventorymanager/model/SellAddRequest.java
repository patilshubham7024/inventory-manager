package com.shop.inventorymanager.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellAddRequest {
    @NotNull(message = "Products should not be empty.")
    private List<SoldProduct> products;

    private String customerName;

    @NotNull(message = "Amount is mandatory.")
    private Double sellAmount;
}
