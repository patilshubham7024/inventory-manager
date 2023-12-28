package com.shop.inventorymanager.exception;

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
}
