package com.company.LimitedTimeDeals.DTO;

import lombok.Getter;

import java.util.List;

@Getter
public class CreateOrderRequest {

    String userId;
    List<String> orderableIds;
    public List<String> getOrderableIds() {
        return orderableIds;
    }

    public String getUserId() {
        return userId;
    }


    public CreateOrderRequest(final String userId, final List<String> orderableIds){
        this.userId = userId;
        this.orderableIds = orderableIds;
    }
}
