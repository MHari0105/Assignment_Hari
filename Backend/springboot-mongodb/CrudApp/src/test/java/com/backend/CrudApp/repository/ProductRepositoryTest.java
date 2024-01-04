package com.backend.CrudApp.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.backend.CrudApp.entity.Product;

@DataMongoTest
public class ProductRepositoryTest {
    
    @Autowired
    private ProductRepository prodRepo;

    @Test
    public void productRepository_saveAll_returnSavedProducts() {

        // ARRANGE
        Product product = Product.builder()
                            .name("Sony")
                            .price(11000.0)
                            .description("Phone").build();

        prodRepo.save(product);

        // ACT 
        Product savedProduct = prodRepo.findById("100").orElse(null);

        // ASSERT
        Assertions.assertThat(savedProduct).isNotNull();
        Assertions.assertThat(savedProduct.getName()).isEqualTo(product.getName());
        Assertions.assertThat(savedProduct.getPrice()).isEqualTo(product.getPrice());
        Assertions.assertThat(savedProduct.getDescription()).isEqualTo(product.getDescription());
    }

}
