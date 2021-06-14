package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class NotesController {

    @Autowired
    NotesService notesService;

    @RequestMapping("/getNotes/{employeeName}")
    @ResponseBody
    public Object displayNotes(@PathVariable String employeeName, @RequestParam String employeeId) {

        return notesService.getEmployeeDetails(employeeName, employeeId);
    }


    @RequestMapping("/createEmployee")
    @ResponseBody
    @PutMapping
    public void createEmployee() {

        notesService.saveEmployee();
    }


    @RequestMapping("/fetchEmployee")
    @ResponseBody
    @GetMapping
    public Object fetchEmployee() {

        return notesService.fetchEmployee();
    }

    @RequestMapping("/saveEmployeeUsingExchange")
    @ResponseBody
    @PutMapping
    public void saveEmployee() {

        notesService.saveEmployeeUsingExchange();
    }
}
