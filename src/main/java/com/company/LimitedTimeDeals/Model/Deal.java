package com.company.LimitedTimeDeals.Model;

import com.company.LimitedTimeDeals.DTO.CreateDealRequest;
import com.company.LimitedTimeDeals.Exception.InvalidInputException;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Deal extends Orderable {
    Product product;

    Double price;
    AtomicInteger quantity;

    public LocalDateTime getEndtime() {
        return endtime;
    }

    public void setQuantity(AtomicInteger quantity) {
        this.quantity = quantity;
    }

    LocalDateTime endtime;

    public Product getProduct() {
        return product;
    }

    public Double getPrice() {
        return price;
    }

    public AtomicInteger getQuantity() {
        return quantity;
    }

    public Deal(final Product product, final Double price, final Integer quantity, final LocalDateTime endtime) throws InvalidInputException {
        super();
        if (quantity > product.quantity.get()){
            throw new InvalidInputException("Deal can not have more quantity than products");
        }
        this.product = product;
        this.price = price;
        this.quantity = new AtomicInteger(quantity);
        this.endtime = endtime;
    }

    public static Deal getDealFromRequest(CreateDealRequest createDealRequest, Product product) throws InvalidInputException {
        LocalDateTime endTime = LocalDateTime.now().plusSeconds(createDealRequest.getDurationInSec());
        return new Deal(product, createDealRequest.getPrice(), createDealRequest.getQuantity(), endTime);
    }

}
