package com.ShoppingCart.OrderService.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShoppingCart.OrderService.entities.Order;
import com.ShoppingCart.OrderService.external.client.ProductService;
import com.ShoppingCart.OrderService.model.OrderRequest;
import com.ShoppingCart.OrderService.repository.OrderRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService{
    

    @Autowired
    private OrderRepository orderRepository;


    @Autowired
    private ProductService productService;
    
    @Override
    public long placeOrder(OrderRequest orderRequest) {
        
        // Order Entity - save the data with order created
        // Product Service - Block Products(Reduce the Quantity)
        // Payment Service -> Payments -> Success -> COMPLETE Else Cancelled 
        log.info("Placing Order Request: {} ", orderRequest);

        productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());

        log.info("Creating Order with status CREATED");
        Order order = Order.builder()
                           .orderStatus("CREATED")
                           .orderDate(Instant.now())
                           .productId(orderRequest.getProductId())
                           .amount(orderRequest.getTotalAmount())
                           .quantity(orderRequest.getQuantity())
                           .build();
        
        order = orderRepository.save(order);

        log.info("Order Placed Successfuly with Order Id: {} ", order.getId());
        return order.getId();
    }

}
