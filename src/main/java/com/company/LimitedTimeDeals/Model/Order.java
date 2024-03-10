package com.company.LimitedTimeDeals.Model;

import com.company.LimitedTimeDeals.DTO.CreateOrderRequest;
import com.company.LimitedTimeDeals.Exception.InvalidInputException;

import java.util.List;
import java.util.UUID;

public class Order {
    String id;

    String userId;

    public String getUserId() {
        return userId;
    }

    public String getId() {
        return id;
    }

    public List<Orderable> getItems() {
        return items;
    }

    List<Orderable> items;

    public Order(String userId, List<Orderable> items){
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.items = items;
    }


    public static Order getOrderFromRequest(CreateOrderRequest createOrderRequest, List<Orderable> items) throws InvalidInputException {
        return new Order(createOrderRequest.getUserId(), items);
    }
}
