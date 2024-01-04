package com.backend.CrudApp.service;

import java.util.List;

import com.backend.CrudApp.entity.Product;
import com.backend.CrudApp.exception.NoProductFoundException;

public interface ProductService {

    String saveProduct(Product product);
    List<Product> getProducts();
    Product getProduct(String prodId);
    String deleteProduct(String prodId);
    Product updateProduct(String prodId, Product product) throws NoProductFoundException;

}
