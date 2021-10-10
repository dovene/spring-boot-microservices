package com.dev.apistarter.controller;

import com.dev.apistarter.exceptionhandler.ProductAlreadyExistException;
import com.dev.apistarter.exceptionhandler.ProductNotFoundException;
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
        Product product = productRepository.findById(reference);
        if(product == null){
            throw new ProductNotFoundException(reference);
        }
        return product;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        Product temporaryProduct = productRepository.save(product);
        if (temporaryProduct == null) {
            throw new ProductAlreadyExistException(product.getReference());
        }
        return temporaryProduct;
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product){
        Product temporaryProduct = productRepository.update(product);
        if (temporaryProduct == null) {
            throw new ProductNotFoundException(product.getReference());
        }
        return temporaryProduct;
    }

    @DeleteMapping("/{reference}")
    public Product deleteProduct(@PathVariable String reference){
        Product temporaryProduct = productRepository.deleteById(reference);
        if (temporaryProduct == null) {
            throw new ProductNotFoundException(reference);
        }
        return temporaryProduct;
    }
}
