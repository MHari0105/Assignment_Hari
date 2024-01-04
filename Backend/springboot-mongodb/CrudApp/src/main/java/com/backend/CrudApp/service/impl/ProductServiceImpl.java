package com.backend.CrudApp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.CrudApp.entity.Product;
import com.backend.CrudApp.exception.NoProductFoundException;
import com.backend.CrudApp.repository.ProductRepository;
import com.backend.CrudApp.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository prodRepo;

    @Override
    public String saveProduct(Product product) {
        String prodId = product.getProdId();
        Optional<Product> existing = prodRepo.findById(prodId);

        if (existing.isPresent())
            return "Product with id " + prodId + " already exists";
        else {
            prodRepo.save(product);
            return "Product " + product.getProdId() + " saved";
        }
        
    }

    @Override
    public List<Product> getProducts() {
        return prodRepo.findAll();
    }

    @Override
    public Product getProduct(String prodId) {
        return prodRepo.findById(prodId).get();
    }

    @Override
    public String deleteProduct(String prodId) {
        boolean deleted = false;
        if (prodRepo.existsById(prodId)) {
            prodRepo.deleteById(prodId);
            deleted = true;
        }
        return "Product Id " + prodId + " deleted status : " + deleted;
    }

    @Override
    public Product updateProduct(String prodId, Product product) throws NoProductFoundException {
        Optional<Product> existing = prodRepo.findById(prodId);
        Product existProduct = null;

        if (existing.isPresent()) {
            existProduct = existing.get();
            existProduct.setName(product.getName());
            existProduct.setPrice(product.getPrice());
            existProduct.setDescription(product.getDescription());

            prodRepo.save(existProduct);
        }

        if (existProduct == null) {
            throw new NoProductFoundException("Product Not Found");
        }

        return existProduct;
    }
    
}
