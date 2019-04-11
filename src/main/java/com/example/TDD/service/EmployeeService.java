package com.example.TDD.service;

import com.example.TDD.bo.Employee;

import java.util.List;

/**
 * Created by np85075 on 4/11/2019.
 */
public interface EmployeeService {

    Employee createEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    Employee updateEmployee(Employee employee);
    boolean deleteEmployee(int id);
}
