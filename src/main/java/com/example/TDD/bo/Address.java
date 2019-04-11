package com.example.TDD.bo;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by np85075 on 4/11/2019.
 */
@Entity
public class Address {

    @Id
    private int id;
    private String street;
    private String city;
    private String pinCode;

    public Address(){}
    public Address(int id,String street,String city,String pinCode){
        this.id=id;
        this.street=street;
        this.city=city;
        this.pinCode=pinCode;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public String getStreet() {
        return street;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
