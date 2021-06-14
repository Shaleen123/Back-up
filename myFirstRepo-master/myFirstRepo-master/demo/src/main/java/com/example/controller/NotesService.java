package com.example.controller;

import com.example.model.Employee;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class NotesService {

    private final String url = "http://localhost:8080/employee/employeeDetails/{employeeName}?employeeId={employeeId}";
    private final String postUrl = "http://localhost:8080/employee/employeeDetails/createEmployee";

    private final RestTemplate restTemplate;

    public NotesService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder
                .basicAuthentication("user", "shaleen")
                .build();
    }

    public Employee[] getEmployeeDetails(String name, String empId) {
        Map<String, String> params = new HashMap<>();
        params.put("employeeName", name);
        params.put("employeeId", empId);
        return restTemplate.getForObject(url, Employee[].class, params);

    }

    public void saveEmployee() {
        Employee employee = new Employee();
        employee.setEmpId("1566380");
        employee.setEmpName("Swati");
        employee.setDeptName("Barclays");
        employee.setSalary(5);

        restTemplate.postForObject(postUrl, employee, Employee.class, (Object) null);

    }

    public ResponseEntity<Employee[]> fetchEmployee() {
        Map<String, String> params = new HashMap<>();
        params.put("employeeName", "name");
        params.put("employeeId", "empId");
        return restTemplate.exchange(url, HttpMethod.GET, null, Employee[].class, params);

    }


    public void saveEmployeeUsingExchange() {
        Employee employee = new Employee();
        employee.setEmpId("1566380");
        employee.setEmpName("Swati");
        employee.setDeptName("Barclays");
        employee.setSalary(5);
        HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, null);

        ResponseEntity responseEntity = restTemplate.exchange(postUrl, HttpMethod.POST, entity, String.class, (Object) null);
        System.out.println("Status code is :" + responseEntity.getStatusCode());

    }

}
