package com.oleglmn.onlineshop.web.rest;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.oleglmn.onlineshop.domain.model.Product;
import com.oleglmn.onlineshop.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/")
@XRayEnabled
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{productId}")
    @Transactional(readOnly = true)
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @PutMapping("{productId}/add")
    @Transactional
    public ResponseEntity<Product> putProductById(@PathVariable Long productId, @RequestBody Product product) {
        return ResponseEntity.ok(productService.putProductById(productId, product));
    }
}
