package com.dev.apistarter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "product")
public class Product {
    @Id
    @Column(name = "reference")
    private String reference;

    @Column(name = "designation")
    private String designation;

    @Column(name = "price")
    private Double price;

    public Product() {
    }

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
