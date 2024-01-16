package com.shop.inventorymanager.exception;

import com.shop.inventorymanager.exception.customException.PurchaseException;
import com.shop.inventorymanager.exception.customException.SellException;
import com.shop.inventorymanager.exception.model.PurchaseExceptionResponse;
import com.shop.inventorymanager.exception.model.SellExceptionResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception exception) {
        log.error("Exception occurred : ", exception);
        return exception.getMessage();
    }

    @ExceptionHandler(SellException.class)
    public SellExceptionResponse handleSellException(SellException exception) {
        log.error("Exception while selling : ", exception);
        return SellExceptionResponse.builder().message(exception.getMessage()).build();
    }

    @ExceptionHandler(PurchaseException.class)
    public PurchaseExceptionResponse handleSellException(PurchaseException exception) {
        log.error("Exception while purchasing : ", exception);
        return PurchaseExceptionResponse.builder().message(exception.getMessage()).build();
    }
}
