package com.company.LimitedTimeDeals.Model;

import java.util.UUID;

public class User {
    String id;
    String name;

    public User(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }
}
