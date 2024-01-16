package com.shop.inventorymanager.exception.customException;

import lombok.Getter;

@Getter
public class SellException extends RuntimeException{

    private final String message;

    public SellException (String message) {
        this.message = message;
    }
}
