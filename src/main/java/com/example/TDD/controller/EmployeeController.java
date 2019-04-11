package com.example.TDD.controller;

import com.example.TDD.bo.Employee;
import com.example.TDD.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by np85075 on 4/11/2019.
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAllEmployees(){

        return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.createEmployee(employee),HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee),HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<Boolean> deleteEmplopyee(@RequestParam("id") String id){
        return new ResponseEntity<Boolean>(employeeService.deleteEmployee(Integer.parseInt(id)),HttpStatus.OK);
    }


}
