package com.backend.CrudApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.backend.CrudApp.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    
}
