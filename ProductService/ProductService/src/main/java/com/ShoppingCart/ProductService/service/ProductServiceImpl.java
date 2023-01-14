package com.ShoppingCart.ProductService.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShoppingCart.ProductService.entity.Product;
import com.ShoppingCart.ProductService.exception.ProductServiceCustomException;
import com.ShoppingCart.ProductService.model.ProductRequest;
import com.ShoppingCart.ProductService.model.ProductResponse;
import com.ShoppingCart.ProductService.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{


    @Autowired
    private ProductRepository productRepository;


    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding Product ...");

        Product product  = Product.builder()
                                  .productName(productRequest.getName())
                                  .price(productRequest.getPrice())
                                  .quantity(productRequest.getQuantity())
                                  .build();
        productRepository.save(product);

        log.info("Product Created");
        return product.getProductId();
    }


    @Override
    public ProductResponse getProductById(long productId) {
        
        log.info("Get the product for productid: {}", productId);
        
        Product product = productRepository.findById(productId)
                                           .orElseThrow(()-> 
                                           new ProductServiceCustomException("Product with given id not found","PRODUCT_NOT_FOUND"));

        ProductResponse productResponse = new ProductResponse();

        BeanUtils.copyProperties(product, productResponse);

        return productResponse;
    }
    


}
