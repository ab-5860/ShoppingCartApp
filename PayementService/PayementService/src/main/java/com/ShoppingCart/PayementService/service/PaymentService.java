package com.ShoppingCart.PayementService.service;

import com.ShoppingCart.PayementService.model.PaymentRequest;
import com.ShoppingCart.PayementService.model.PaymentResponse;

public interface PaymentService {

    long doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetailsByOrderId(String orderId);

    
}
