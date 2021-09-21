package com.oleglmn.onlineshop.repository;

import com.oleglmn.onlineshop.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
