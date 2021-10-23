package com.dev.apistarter.exceptionhandler;

public class ProductAlreadyExistException extends RuntimeException {
    public ProductAlreadyExistException(String reference){
        super("Product reference already exists " + reference);
    }
}
