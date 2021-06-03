package com.oleglmn.onlineshop.service;

import com.oleglmn.onlineshop.domain.model.Product;
import com.oleglmn.onlineshop.repository.ProductRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository repository) {
        this.productRepository = repository;
    }

    public Product getProductById(Long productId) {
        Optional<Product> optionalProductById = productRepository.findById(productId);
        if (optionalProductById.isEmpty()) {
            throw new RuntimeException("Product not found with id: " + productId);
        }

        return optionalProductById.get();
    }

    public Product putProductById(Long productId, Product product) {
        product.setId(productId);
        return productRepository.save(product);
    }
}
