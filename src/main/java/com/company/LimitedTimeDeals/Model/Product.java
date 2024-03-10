package com.company.LimitedTimeDeals.Model;


import com.company.LimitedTimeDeals.DTO.CreateProductRequest;
import lombok.Getter;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Product extends Orderable {
    String name;
    Double price;
    AtomicInteger quantity;

    public Product(final String name, final Double price, final Integer quantity){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.quantity = new AtomicInteger(quantity);
    }

    public static Product getProductFromRequest(CreateProductRequest createProductRequest) {
        return new Product(createProductRequest.getName(), createProductRequest.getPrice(), createProductRequest.getQuantity());
    }
}
