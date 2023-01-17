package com.ShoppingCart.PayementService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ShoppingCart.PayementService.entities.TransactionDetails;


@Repository
public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails,Long>{
    
    // give declaration only, implementation will be done by Spring data JPA
    TransactionDetails findByOrderId(long orderId);

}
