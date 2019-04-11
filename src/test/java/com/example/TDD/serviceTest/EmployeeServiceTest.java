package com.example.TDD.serviceTest;

import com.example.TDD.bo.Address;
import com.example.TDD.bo.Employee;
import com.example.TDD.repository.EmployeeRepository;
import com.example.TDD.service.EmployeeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import static org.junit.Assert.assertEquals;

/**
 * Created by np85075 on 4/11/2019.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllEmployees(){
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(10,"Nitin",5000,new Address(100,"MG road","Nashik","422103")));
        employees.add(new Employee(20,"Sagar",5652,new Address(100,"FC road","Pune","14411")));
        employees.add(new Employee(30,"Sachin",1244,new Address(100,"JM road","Mumbai","456545")));
        employees.add(new Employee(40,"Amol",2000,new Address(100,"KFC road","Nashik","411028")));

        when(employeeRepository.findAll()).thenReturn(employees);

        List<Employee> employeesResult = employeeService.getAllEmployees();
        assertEquals(employeesResult.size(),4);
    }

    @Test
    public void createEmployeeTest(){
        Employee employee = new Employee(10,"Nitin",5000,new Address(100,"MG road","Nashik","422103"));
        when(employeeRepository.save(employee)).thenReturn(employee);

        Employee employeeResult = employeeService.createEmployee(employee);

        assertEquals(employeeResult.getId(),10);
        assertEquals(employeeResult.getAddress().getPinCode(),"422103");
    }

    @Test
    public void getEmployeeTest(){
        Employee employee = new Employee(10,"Nitin",5000,new Address(100,"MG road","Nashik","422103"));
        when(employeeRepository.findById(10)).thenReturn(Optional.of(employee));

        Employee employeeResult = employeeService.getEmployeeById(10);
        assertEquals(employeeResult.getName(),"Nitin");
    }
    @Test
    public void deleteEmployeeTest(){
        Employee employee = new Employee(10,"Nitin",5000,new Address(100,"MG road","Nashik","422103"));

        employeeService.deleteEmployee(employee.getId());

        verify(employeeRepository,times(1)).deleteById(employee.getId());
    }
}
