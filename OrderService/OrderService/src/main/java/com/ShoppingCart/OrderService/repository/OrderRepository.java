package com.ShoppingCart.OrderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ShoppingCart.OrderService.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{
    
}
