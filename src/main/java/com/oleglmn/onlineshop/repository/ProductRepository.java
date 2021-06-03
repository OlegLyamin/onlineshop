package com.oleglmn.onlineshop.repository;

import com.oleglmn.onlineshop.domain.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
