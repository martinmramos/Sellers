package com.example.sellers.domain;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Person {

    @NotNull(message = "Name is null")
    @NotBlank(message = "Name is empty")
    private String name;
    @NotNull(message = "Address is null")
    @NotBlank(message = "Address is empty")
    private String address;
    @NotNull(message = "DNI is null")
    @NotBlank(message = "DNI is empty")
    private String dni;
    @Digits(message = "Phone invalid", integer = 9, fraction = 0)
    private int phone;

    public Person(String name, String address, String dni, int phone) {
        this.name = name;
        this.address = address;
        this.dni = dni;
        this.phone = phone;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void updateInfo(String name, String address, int phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
}
