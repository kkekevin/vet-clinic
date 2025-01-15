package com.vetclinic.app.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vetclinic.app.rest.models.Employee;
import com.vetclinic.app.rest.repo.EmployeeRepo;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepo employeeRepo;

    @PostMapping(value = "/employee/save")
    public ResponseEntity<Employee> createEmployee (@RequestBody Employee employee) {
        employeeRepo.save(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
