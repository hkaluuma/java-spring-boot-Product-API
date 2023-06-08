package com.symptom.example.demo.controller;

import com.symptom.example.demo.controller.model.ProductID;
import com.symptom.example.demo.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {
    
//    @GetMapping("/")
//    public String hello(){
//        return "hello world";
//    }

    @PostMapping("/product")
    public ResponseEntity<ProductID> createProduct(@RequestBody final Product product){
        System.out.println(product);
        ProductID result = new ProductID(UUID.randomUUID().toString());
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result);
    }

    @GetMapping("/product")
    public List<Product> getAllProducts(){
        List<Product> result = new ArrayList<>();
        result.add(new Product("1",
                "Prodcut1",
                new BigDecimal("258.24")));
        result.add(new Product("2",
                "Prodcut1",
                new BigDecimal("999.54")));
        result.add(new Product("1",
                "Prodcut1",
                new BigDecimal("794.24")));

        return result;
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable final String id){
        System.out.println(id);
        return new Product("888",
                "returing single product",
                new BigDecimal("2789.67"));
    }

    @PatchMapping("/product")
    public void patchProdcut(@RequestBody Product product){
        System.out.println(product);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable final String id){
        System.out.println(id);
    }

}

