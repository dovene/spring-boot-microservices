package com.dev.apistarter.exceptionhandler;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String reference){
        super("Could not find product " + reference);
    }
}
