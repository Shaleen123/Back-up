package com.learning.assignment.rest.service;

import com.learning.assignment.rest.controller.EmployeeController;
import com.learning.assignment.rest.model.Employee;
import com.learning.assignment.rest.util.EmployeeNotFoundException;
import com.learning.assignment.rest.util.HelperUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Lazy

public class EmployeeService {

    public EmployeeService() {
        System.out.println("Lazy loaded bean");
    }

    @Autowired
    HelperUtil helperUtil;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    public List<Employee> getEmployeeDetails(String empId, String employeeName) {

        logger.info("employeeId is :" + empId + "and Employee name is:" + employeeName);

        List<String> names = List.of("Swati", "Shaleen", "Anbin", "Anshu", "Nikhil");
/*

        if (names.contains(employeeName)) {
            logger.info("Employee found in the database:{}", employeeName);
        } else {
            throw new EmployeeNotFoundException("Employee not found in the database");
        }
*/

        Employee employee = new Employee();
        employee.setEmpName(employeeName);
        employee.setEmpId(empId);
        return List.of(employee);

    }

    public void createEmployee(Employee employee) { logger.info("Employee details are :{}", employee);
    }

    public void createEmployee(Map<String, Employee> employeeDetails) {
        logger.info("Employee map details are :{}", employeeDetails);
        System.out.println("Display value is :" + helperUtil.display());

        employeeDetails.entrySet().stream().forEach(o -> System.out.println("key is :" + o.getKey() + "value is:" +
                o.getValue().toString()));
    }
}
