package com.backend.Project1.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.backend.Project1.entity.RawMaterial;

@DataMongoTest
public class RawMaterialRepoTest {
    
    @Autowired
    private RawMaterialRepo rawMaterialRepo;

    @Test
    public void RawMaterialRepo_saveAllMethods_returnSavedRawMaterial() {

        // ARRANGE
        RawMaterial rawMaterial = RawMaterial.builder()
                                    .materialName("rm100")
                                    .materialTier(2)
                                    .quantity(10.5)
                                    .materialPrice(10000.0).build();

        
        // ACT
        RawMaterial savedRawMaterial = rawMaterialRepo.save(rawMaterial);


        // ASSERT
        Assertions.assertThat(savedRawMaterial).isNotNull();
    }
}
