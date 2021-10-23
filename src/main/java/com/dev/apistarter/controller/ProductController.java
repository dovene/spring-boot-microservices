package com.dev.apistarter.controller;

import com.dev.apistarter.exceptionhandler.ProductAlreadyExistException;
import com.dev.apistarter.exceptionhandler.ProductNotFoundException;
import com.dev.apistarter.model.Product;
import com.dev.apistarter.repository.ProductJpaRepository;
import com.dev.apistarter.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    ProductJpaRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts(){
        return (List<Product>) productRepository.findAll();
    }

    @GetMapping("/{reference}")
    public Product getProductById(@PathVariable String reference){
        Optional<Product> product = productRepository.findById(reference);
        if(product.isEmpty()){
            throw new ProductNotFoundException(reference);
        }
        return product.get();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        if (productRepository.existsById(product.getReference())) {
            throw new ProductAlreadyExistException(product.getReference());
        }
        return productRepository.save(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product){
        if (!productRepository.existsById(product.getReference())) {
            throw new ProductNotFoundException(product.getReference());
        }
        return productRepository.save(product);
    }

    @DeleteMapping("/{reference}")
    public void deleteProduct(@PathVariable String reference){
        if (!productRepository.existsById(reference)) {
            throw new ProductNotFoundException(reference);
        }
        productRepository.deleteById(reference);
    }
}
