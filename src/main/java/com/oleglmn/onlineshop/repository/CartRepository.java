package com.oleglmn.onlineshop.repository;

import com.oleglmn.onlineshop.domain.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
