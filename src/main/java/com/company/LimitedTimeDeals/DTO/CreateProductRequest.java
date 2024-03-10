package com.company.LimitedTimeDeals.DTO;

import lombok.Getter;

@Getter
public class CreateProductRequest {
    String name;
    Double price;

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    int quantity;

    public CreateProductRequest(final String name, final Double price, final int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
