package com.company.LimitedTimeDeals.DTO;

import lombok.Getter;

@Getter
public class CreateDealRequest {
    String name;
    String productId;
    Double price;

    int durationInSec;

    public int getDurationInSec() {
        return durationInSec;
    }

    public String getName() {
        return name;
    }
    public String getProductId() {
        return productId;
    }

    public Double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    int quantity;

    public CreateDealRequest(final String name, final String productId, final Double price, final int quantity, final int durationInSec){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.durationInSec = durationInSec;
    }
}
