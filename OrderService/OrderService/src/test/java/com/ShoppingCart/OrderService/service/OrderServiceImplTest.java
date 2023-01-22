package com.ShoppingCart.OrderService.service;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.ShoppingCart.OrderService.external.client.PaymentService;
import com.ShoppingCart.OrderService.external.client.ProductService;
import com.ShoppingCart.OrderService.repository.OrderRepository;

@SpringBootTest
public class OrderServiceImplTest {


    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ProductService productService;

    @Mock
    private PaymentService paymentService;

    @Mock
    private RestTemplate restTemplate;
    
    @InjectMocks
    OrderService orderService = new OrderServiceImpl();

}
