package org.vaslabs.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.vaslabs.dto.Product;
import org.vaslabs.service.ProductServiceRPC;

import java.util.List;

@RestController
public class ProductController {

    private final ProductServiceRPC productServiceRPC;

    public ProductController(ProductServiceRPC productServiceRPC) {
        this.productServiceRPC = productServiceRPC;
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id){
        return ResponseEntity.ok().body(productServiceRPC.getProductById(Integer.parseInt(id)));
    }

    @GetMapping(value = "/product/category/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getProductByCategoryId(@PathVariable String id){
        return ResponseEntity.ok().body(productServiceRPC.getProductByCategoryId(Integer.parseInt(id)));
    }
}
