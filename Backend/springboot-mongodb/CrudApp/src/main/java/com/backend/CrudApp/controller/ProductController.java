package com.backend.CrudApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.CrudApp.entity.Product;
import com.backend.CrudApp.exception.NoProductFoundException;
import com.backend.CrudApp.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService prodService;

    @PostMapping("/save")
    public ResponseEntity<String> saveProduct(@RequestBody Product product) {
        return new ResponseEntity<>(prodService.saveProduct(product), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<List<Product>>(prodService.getProducts(), HttpStatus.OK);
    }
    
    @GetMapping("/get/{prodId}")
    public ResponseEntity<Product> getProductById(@PathVariable String prodId) {
        return new ResponseEntity<Product>(prodService.getProduct(prodId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{prodId}")
    public ResponseEntity<String> deleteProduct(@PathVariable String prodId) {
        return new ResponseEntity<String>(prodService.deleteProduct(prodId), HttpStatus.OK);
    }

    @PutMapping("/update/{prodId}")
    public ResponseEntity<Product> updateProduct(@PathVariable String prodId, @RequestBody Product product) throws NoProductFoundException {
        return new ResponseEntity<Product>(prodService.updateProduct(prodId, product), HttpStatus.OK);
    }
}
