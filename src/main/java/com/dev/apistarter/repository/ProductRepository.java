package com.dev.apistarter.repository;

import com.dev.apistarter.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private ArrayList<Product> products = new ArrayList<>(
  Arrays.asList( new Product("P1", "bread", 12.0),
            new Product("P2", "sugar", 2.5) ));

    public List<Product> findAll(){
        return products;
    }

    public Product findById(String reference){
        List<Product> matchingItems = products.stream().filter(new Predicate<Product>() {
            @Override
            public boolean test(Product product) {
                return reference.equals(product.getReference());
            }
        }).collect(Collectors.toList());
        return matchingItems.size()==0 ? null : matchingItems.get(0);
    }

    public Product save(Product product){
        if (findById(product.getReference()) != null) {
            return null;
        } else {
            products.add(product);
            return product;
        }
    }

    public Product update(Product newProduct){
        if (findById(newProduct.getReference()) == null) {
            return null;
        } else {
            products.stream().forEach(new Consumer<Product>() {
                @Override
                public void accept(Product product) {
                    if (newProduct.getReference().equals(product.getReference())){
                        product.setDesignation(newProduct.getDesignation());
                        product.setPrice(newProduct.getPrice());
                    }
                }
            });
            return newProduct;
        }
    }

    public Product deleteById(String reference){
        if (findById(reference) != null) {
            Product product = findById(reference);
            products.remove(product);
            return product;
        } else {
            return null;
        }
    }

}
