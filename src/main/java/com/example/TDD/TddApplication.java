package com.example.TDD;

import com.example.TDD.bo.Address;
import com.example.TDD.bo.Employee;
import com.example.TDD.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TddApplication {

	public static void main(String[] args) {
		SpringApplication.run(TddApplication.class, args);

	}

	@Bean
	public CommandLineRunner setup(EmployeeRepository employeeRepository){
		return (args)->{
			employeeRepository.save(new Employee(10,"Nitin",5000,new Address(100,"MG road","Nashik","422103")));
			employeeRepository.save(new Employee(20,"Sagar",5652,new Address(100,"FC road","Pune","14411")));
			employeeRepository.save(new Employee(30,"Sachin",1244,new Address(100,"JM road","Mumbai","456545")));
			employeeRepository.save(new Employee(40,"Amol",2000,new Address(100,"KFC road","Nashik","411028")));
		};
	}
}
