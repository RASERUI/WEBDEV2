package com.russellroy.demo.controller;

import com.russellroy.demo.dto.ProductDTO;
import com.russellroy.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO dto) {
        return service.createProduct(dto);
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return service.getAllProducts();
    }
}
