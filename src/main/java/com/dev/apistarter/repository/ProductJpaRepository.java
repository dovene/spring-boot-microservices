package com.dev.apistarter.repository;

import com.dev.apistarter.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends CrudRepository<Product, String> {
}
