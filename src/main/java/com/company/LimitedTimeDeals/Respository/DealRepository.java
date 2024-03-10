package com.company.LimitedTimeDeals.Respository;

import com.company.LimitedTimeDeals.Model.Deal;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class DealRepository {

    HashMap<String, Deal> DealIdToObjectMapping;
    public DealRepository(){
        this.DealIdToObjectMapping = new HashMap<>();
    }

    public Deal createDeal(final Deal Deal){
        this.DealIdToObjectMapping.put(Deal.getId(), Deal);
        return this.DealIdToObjectMapping.get(Deal.getId());
    }

    public Deal getDeal(final String DealId) {
        return this.DealIdToObjectMapping.get(DealId);
    }

//    public Deal updateDeal(final Deal Deal) {
//        this.DealIdToObjectMapping
//    }

    public Deal deleteDeal(final String DealId) {
        final Deal Deal = this.getDeal(DealId);
        this.DealIdToObjectMapping.remove(DealId);
        return Deal;
    }
}
