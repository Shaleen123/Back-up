package com.learning.assignment.config;

import com.learning.assignment.rest.util.HelperUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Factory {

    @Bean
    public HelperUtil createBean() {
        return new HelperUtil();
    }
}
