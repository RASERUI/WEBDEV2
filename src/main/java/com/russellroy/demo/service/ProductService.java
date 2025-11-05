package com.russellroy.demo.service;

import com.russellroy.demo.dto.ProductDTO;
import com.russellroy.demo.model.Product;
import com.russellroy.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductDTO createProduct(ProductDTO dto) {
        Product product = new Product(null, dto.getName(), dto.getPrice());
        Product saved = repository.save(product);
        return new ProductDTO(saved.getName(), saved.getPrice());
    }

    public List<ProductDTO> getAllProducts() {
        return repository.findAll().stream()
                .map(p -> new ProductDTO(p.getName(), p.getPrice()))
                .collect(Collectors.toList());
    }
}
