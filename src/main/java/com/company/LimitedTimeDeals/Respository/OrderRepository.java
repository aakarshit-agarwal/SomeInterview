package com.company.LimitedTimeDeals.Respository;

import com.company.LimitedTimeDeals.Model.Deal;
import com.company.LimitedTimeDeals.Model.Order;
import com.company.LimitedTimeDeals.Model.Orderable;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;

@Repository
public class OrderRepository {

    HashMap<String, Order> orderIdToObjectMapping;
    HashSet<String> userIdDealIdMappings;

    public OrderRepository(){
        this.orderIdToObjectMapping = new HashMap<>();
        this.userIdDealIdMappings = new HashSet<>();
    }

    public Order createOrder(final Order order){
        for(Orderable item: order.getItems()){
            if (item instanceof Deal){
                String userIdDealId = order.getUserId() + "_" + item.getId();
                this.userIdDealIdMappings.add(userIdDealId);
            }
        }
        this.orderIdToObjectMapping.put(order.getId(), order);
        return this.orderIdToObjectMapping.get(order.getId());
    }

    public Order getOrder(final String orderId) {
        return this.orderIdToObjectMapping.get(orderId);
    }

//    public Order updateOrder(final Order Order) {
//        this.OrderIdToObjectMapping
//    }

    public boolean isDealOrderedByUser(final String userId, final String dealId){
        String userIdDealId = userId + "_" + dealId;
        return this.userIdDealIdMappings.contains(userIdDealId);
    }
    public Order deleteOrder(final String orderId) {
        final Order order = this.getOrder(orderId);
        this.orderIdToObjectMapping.remove(orderId);
        return order;
    }
}
