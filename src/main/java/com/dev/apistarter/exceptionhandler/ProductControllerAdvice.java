package com.dev.apistarter.exceptionhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProductControllerAdvice {
    private static final Logger logger = LoggerFactory.getLogger(ProductControllerAdvice.class);

    @ResponseBody
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String productNotFoundHandler(ProductNotFoundException ex) {
        logger.error(ex.getMessage());
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ProductAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String productAlreadyExistHandler(ProductAlreadyExistException ex) {
        logger.error(ex.getMessage());
        return ex.getMessage();
    }
}
