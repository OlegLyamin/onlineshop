package com.oleglmn.onlineshop.service;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.oleglmn.onlineshop.domain.model.Cart;
import com.oleglmn.onlineshop.domain.model.Product;
import com.oleglmn.onlineshop.repository.CartRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@XRayEnabled
public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Transactional
    public List<Product> getCartById(Long cartId) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        if (optionalCart.isPresent()) {
            return new ArrayList<>(optionalCart.get().getProducts());
        }

        Cart cart = new Cart();

        cart = cartRepository.save(cart);

        return cart.getProducts();
    }

    public void deleteCartById(Long cartId) {
        cartRepository.findById(cartId).ifPresent(cartRepository::delete);
    }

    @Transactional
    public Cart putProductByCartId(Long cartId) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);

        if (optionalCart.isEmpty()) {
            throw new RuntimeException("Cart not found");
        }

        Random random = new Random();

        Product product = new Product();
        product.setTitle("defaultProduct ".concat(String.valueOf(random.nextInt(100))));

        optionalCart.ifPresent(cart1 -> cart1.getProducts().add(product));

        return optionalCart.get();
    }
}
