package com.company.LimitedTimeDeals.Model;

import java.util.UUID;

public abstract class Orderable {
    String id;

    public Orderable(){
        this.id = UUID.randomUUID().toString();
    }
    public String getId(){
        return this.id;
    }

}
