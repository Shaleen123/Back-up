package com.learning.assignment.rest.service.circularDependency;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class BeanA {

    //one solution is to have setter method for bean b here another way is to lazy load the bean
  /*  public void setB(BeanB b) {
        this.b = b;
    }*/
    BeanB b;

    public BeanA(@Lazy BeanB b) {
        this.b = b;

    }

}
