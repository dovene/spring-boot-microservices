package com.dev.apistarter.controller;

import com.dev.apistarter.model.Product;
import com.dev.apistarter.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/{reference}")
    public Product getProductById(@PathVariable String reference){
        return productRepository.findById(reference);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product){
        return productRepository.update(product);
    }

    @DeleteMapping("/{reference}")
    public Product deleteProduct(@PathVariable String reference){
        return productRepository.deleteById(reference);
    }
}
