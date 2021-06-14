package com.learning.assignment.rest.util;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving ferrari");
    }
}
