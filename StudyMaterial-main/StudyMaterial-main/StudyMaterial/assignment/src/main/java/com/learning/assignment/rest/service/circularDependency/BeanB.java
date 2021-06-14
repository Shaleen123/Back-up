package com.learning.assignment.rest.service.circularDependency;

import org.springframework.stereotype.Component;

@Component
public class BeanB {

    BeanA a;

    public BeanB(BeanA a) {
        this.a = a;
    }
}
