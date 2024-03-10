package com.company.LimitedTimeDeals.Validations;

import com.company.LimitedTimeDeals.DTO.CreateDealRequest;
import com.company.LimitedTimeDeals.DTO.CreateOrderRequest;
import com.company.LimitedTimeDeals.Model.Product;
import com.company.LimitedTimeDeals.Respository.DealRepository;
import com.company.LimitedTimeDeals.Respository.OrderRepository;
import com.company.LimitedTimeDeals.Respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderValidation {
    OrderRepository orderRepository;
    ProductRepository productRepository;
    DealRepository dealRepository;

    public OrderValidation(@Autowired OrderRepository orderRepository, @Autowired ProductRepository productRepository, @Autowired DealRepository dealRepository){
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.dealRepository = dealRepository;
    }
    public boolean isValidCreateOrderRequest(CreateOrderRequest createOrderRequest){
        for (String itemId: createOrderRequest.getOrderableIds()) {
            if(this.orderRepository.isDealOrderedByUser(createOrderRequest.getUserId(), itemId)){
                return false;
            }
        }
        return true;
    }
}
