package com.oleglmn.onlineshop.service;

import com.amazonaws.xray.AWSXRay;
import com.amazonaws.xray.spring.aop.XRayEnabled;
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
        AWSXRay.beginSegment("getProductById");

        Optional<Product> optionalProductById = productRepository.findById(productId);
        if (optionalProductById.isEmpty()) {
            throw new RuntimeException("Product not found with id: " + productId);
        }
        AWSXRay.endSegment();

        return optionalProductById.get();
    }

    public Product putProductById(Long productId, Product product) {

        Optional<Product> optionalProductById = productRepository.findById(productId);
        if (optionalProductById.isEmpty()) {
            product.setId(productId);
            return productRepository.save(product);
        }

        Product product1 = optionalProductById.get();
        product1.setTitle(product.getTitle());

        return productRepository.save(product1);
    }
}
