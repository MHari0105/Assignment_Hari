package com.mongodb.Crudapp.controller;

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

import com.mongodb.Crudapp.dto.AuthRequest;
import com.mongodb.Crudapp.entity.Product;
import com.mongodb.Crudapp.exception.NoProductFoundException;
import com.mongodb.Crudapp.service.JwtService;
import com.mongodb.Crudapp.service.ProductService;

@RestController
@RequestMapping("/product/") 
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @Autowired
    private JwtService jwtService;

    // CRUD OPERATIONS

    @PostMapping("/save")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        return new ResponseEntity<String>(productService.saveProduct(product), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> readAllProduct() {
        return new ResponseEntity<List<Product>>(productService.getAllProducts(), HttpStatus.OK);
    }

    @RequestMapping("/get/{prodId}")
    public ResponseEntity<Product> readProductById(@PathVariable Long prodId) {
        return new ResponseEntity<Product>(productService.getProductById(prodId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{prodId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long prodId) {
        return new ResponseEntity<String>(productService.deleteProductById(prodId), HttpStatus.OK);
    }

    @PutMapping("/update/{prodId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long prodId, @RequestBody Product product) throws NoProductFoundException {
        return new ResponseEntity<Product>(productService.updateProduct(prodId, product), HttpStatus.OK);
    }

    // JWT TOKEN 
    
    @PostMapping("/authenticate")
    public String authenticateAbdGetToken(@RequestBody AuthRequest authReq) {
        return jwtService.generateToken(authReq.getUsername());
    }
}
