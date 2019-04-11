package com.example.TDD.bo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by np85075 on 4/11/2019.
 */
@Entity
public class Employee {

    @Id
    private int id;
    private String name;
    private double salary;
    @OneToOne
    private Address address;

    public Employee(){}
    public Employee(int id,String name,double salary,Address address){
        this.id=id;
        this.name=name;
        this.salary=salary;
        this.address=address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}
