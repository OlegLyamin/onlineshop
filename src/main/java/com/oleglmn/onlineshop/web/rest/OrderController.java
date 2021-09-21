package com.oleglmn.onlineshop.web.rest;

import com.oleglmn.onlineshop.service.OrderService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/checkout/{cartId}")
    @Transactional
    public void checkout(@PathVariable(required = false) Long cartId) {
        orderService.checkout(cartId);
    }

}
