package com.mongodb.Crudapp.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.mongodb.Crudapp.entity.Product;

@DataMongoTest
public class ProductRepositoryTest {
    
    @Autowired
    private ProductRepository prodRepo;

    @Test
    public void productRepository_saveAll_returnSavedProduct() {

        // ARRANGE
        Product product = Product.builder()
                    .name("Sony").prodCode(5000).price(21000.0).desc("Phone")
                    .build();

        // ACT
        prodRepo.save(product);

        Product savedProduct = prodRepo.findById(100L).orElse(product);

        // ASSERT
        Assertions.assertThat(savedProduct).isNotNull();
        Assertions.assertThat(savedProduct.getProdId()).isEqualTo(product.getProdId());
    }

}
