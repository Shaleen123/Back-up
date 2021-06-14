package com.learning.assignment;

import com.learning.assignment.rest.service.EmployeeService;
import com.learning.assignment.rest.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//For disabling the auto security
//@SpringBootApplication consists of @configuration, @component scan and @EnableAutoConfiguration
@EnableSwagger2

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})

@ComponentScan(basePackages = {"com.learning.assignment.rest",
        "com.learning.assignment.config"
})

public class AssignmentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(AssignmentApplication.class, args);
        EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);
        System.out.println("hashcode of employeeService is :" + employeeService.hashCode());
        EmployeeService employeeService2 = applicationContext.getBean(EmployeeService.class);
        System.out.println("hashcode of employeeService is :" + employeeService2.hashCode());
        //prototype testing
        UserService userService = applicationContext.getBean(UserService.class);
        System.out.println("hashcode of userService is :" + userService.hashCode());
        UserService userService2 = applicationContext.getBean(UserService.class);
        System.out.println("hashcode of userService is :" + userService2.hashCode());
    }


    //@Swagger customization:Return a new Docket object with base package and path
    @Bean
    public Docket swaggerConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //.paths(PathSelectors.ant("/employee/*"))
                .apis(RequestHandlerSelectors.basePackage("com.learning.assignment"))
                .build();
    }

}
