package com.shop.inventorymanager.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellOrderDTO {
    private List<SoldProductDTO> products;
    private String customerName;
    private Double sellAmount;
}
