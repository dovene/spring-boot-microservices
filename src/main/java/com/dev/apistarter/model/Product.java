package com.dev.apistarter.model;

public class Product {
    private String reference;
    private String designation;
    private Double price;

    public Product(String reference, String designation, Double price) {
        this.reference = reference;
        this.designation = designation;
        this.price = price;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
