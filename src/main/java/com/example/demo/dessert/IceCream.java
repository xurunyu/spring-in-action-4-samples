package com.example.demo.dessert;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Cold
@Creamy
public class IceCream implements Dessert {
}
