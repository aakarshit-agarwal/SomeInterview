package com.company.LimitedTimeDeals.Service;

import com.company.LimitedTimeDeals.DTO.CreateOrderRequest;
import com.company.LimitedTimeDeals.Exception.InvalidInputException;
import com.company.LimitedTimeDeals.Model.Deal;
import com.company.LimitedTimeDeals.Model.Order;
import com.company.LimitedTimeDeals.Model.Orderable;
import com.company.LimitedTimeDeals.Model.Product;
import com.company.LimitedTimeDeals.Respository.DealRepository;
import com.company.LimitedTimeDeals.Respository.OrderRepository;
import com.company.LimitedTimeDeals.Respository.ProductRepository;
import com.company.LimitedTimeDeals.Validations.OrderValidation;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderService {

    OrderRepository orderRepository;
    ProductRepository productRepository;
    DealRepository dealRepository;
    OrderValidation orderValidation;
    public OrderService(@Autowired OrderRepository orderRepository, @Autowired DealRepository dealRepository, @Autowired ProductRepository productRepository,
    @Autowired OrderValidation orderValidation){
        this.orderRepository = orderRepository;
        this.dealRepository = dealRepository;
        this.productRepository = productRepository;
        this.orderValidation = orderValidation;
    }
    public Order createOrder(CreateOrderRequest createOrderRequest) throws InvalidInputException {
        List<Orderable> items = new ArrayList<>();
        for(String id: createOrderRequest.getOrderableIds()){
            Deal deal = this.dealRepository.getDeal(id);
            if (deal != null && deal.getQuantity().get() >= 0 && LocalDateTime.now().isBefore(deal.getEndtime())) {
                items.add(deal);
                synchronized ((deal)) {
                    deal.setQuantity(deal.getQuantity().get()+1);
                }
                continue;
            }
            Product product = this.productRepository.getProduct(id);
            if(product != null) {
                items.add(product);
                continue;
            }
            throw new InvalidInputException("Invalid Product/Deal Id");
        }
        if(!this.orderValidation.isValidCreateOrderRequest(createOrderRequest)) {
            throw new InvalidInputException("Invalid Order");
        }
        Order order = Order.getOrderFromRequest(createOrderRequest, items);
        return this.orderRepository.createOrder(order);
    }
}
