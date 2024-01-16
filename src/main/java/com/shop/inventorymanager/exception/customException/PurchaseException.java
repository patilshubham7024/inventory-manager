package com.shop.inventorymanager.exception.customException;

import lombok.Getter;

@Getter
public class PurchaseException extends RuntimeException{

    private final String message;

    public PurchaseException (String message) {
        this.message = message;
    }
}
