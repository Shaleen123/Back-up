package com.learning.assignment.config;

import com.learning.assignment.rest.util.EmployeeNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ApiExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseBody
    public ResponseEntity handleNotFoundError(EmployeeNotFoundException employeeNotFoundException) {
        logger.error("Employee not found in the database");
        return new ResponseEntity(employeeNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
}
