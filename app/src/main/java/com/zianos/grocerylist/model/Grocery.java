package com.zianos.grocerylist.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Grocery {

    @Id
    private Long id;

    private String name;

    private double price;

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Generated(hash = 960124844)
    public Grocery(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Generated(hash = 986816186)
    public Grocery() {
    }
}
