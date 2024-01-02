package com.shop.inventorymanager.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellAddResponse implements Serializable {
    private String message;
}
