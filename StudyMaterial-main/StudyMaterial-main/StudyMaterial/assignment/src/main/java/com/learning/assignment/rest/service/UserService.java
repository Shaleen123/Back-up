package com.learning.assignment.rest.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class UserService {
    public String getUserName() {
        return "Shaleen";
    }
}
