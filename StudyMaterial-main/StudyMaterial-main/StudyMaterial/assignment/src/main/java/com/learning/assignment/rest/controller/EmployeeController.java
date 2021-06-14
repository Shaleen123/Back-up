package com.learning.assignment.rest.controller;

import com.learning.assignment.rest.model.Employee;
import com.learning.assignment.rest.service.EmployeeService;
import com.learning.assignment.rest.util.Vehicle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @Author:Shaleen Madlapure
 * This controller has exception handling, ambiguity handling, validations and autowiring concepts explained
 */
@RestController
@RequestMapping("/employee")

public class EmployeeController {

    //If an interface having multiple implementations and if you are autowiring the interface
    // then ambiguity will occur
    //Solution:Use @Primary with one of the service class ,use @Qualifier at the time of autowiring
    // or use the service object name with interface to solve the issues.
    //@Qualifier("bike")
    @Autowired
    Vehicle bike;

    EmployeeService employeeService;

    //constructor dependency injection
    @Lazy
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    @RequestMapping("/employeeDetails/{employeeName}")
    @ApiOperation("This will fetch the employee details")//Swagger used here
    public List<Employee> getEmployeeDetails(@RequestParam String employeeId,
                                   @PathVariable String employeeName) {
        return employeeService.getEmployeeDetails(employeeId, employeeName);
    }

    //POJO example of request body
    @PutMapping
    @RequestMapping("/employeeDetails/createEmployee")
    public void createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
    }

    //Collections example of request body
    //make sure you are passing value as custom object not key
    @PutMapping
    @RequestMapping("/createEmployeeUsingMap")
    public void createEmployeeUsingCollections(@RequestBody Map<String, Employee> employeeDetails) {
        System.out.println("employeeDetails are :" + employeeDetails);
        employeeService.createEmployee(employeeDetails);

    }

    //@Valid will work with javax.annotations ,You need to apply java x annotations like min,max,not null in pojo classes and then use @Valid with requestBody
    @PutMapping
    @RequestMapping("/validate")
    public void createEmployeeAndValidate(@Valid @RequestBody Employee employee) {
        System.out.println("employeeDetails are :" + employee);
        bike.drive();
        employeeService.createEmployee(employee);

    }


}
