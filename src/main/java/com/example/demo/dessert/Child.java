package com.example.demo.dessert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Child {
    public Dessert dessert;

    @Autowired
    @Soft
    @Crispy
    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    public void eat() {
        System.out.println(dessert.toString());
    }
}
