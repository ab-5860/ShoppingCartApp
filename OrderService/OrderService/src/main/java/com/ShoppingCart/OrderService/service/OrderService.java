package com.ShoppingCart.OrderService.service;

import com.ShoppingCart.OrderService.model.OrderRequest;

public interface OrderService {

    long placeOrder(OrderRequest orderRequest);
    
}
