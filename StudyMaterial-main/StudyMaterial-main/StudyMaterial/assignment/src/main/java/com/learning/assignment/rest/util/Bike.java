package com.learning.assignment.rest.util;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding bike");
    }
}
