package com.example.TDD.repository;

import com.example.TDD.bo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by np85075 on 4/11/2019.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
