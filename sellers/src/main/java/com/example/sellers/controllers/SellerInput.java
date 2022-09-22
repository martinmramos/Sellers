package com.example.sellers.controllers;

import javax.validation.constraints.*;

public class SellerInput {

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

    public SellerInput(String name, String address, String dni, int phone) {
        this.name = name;
        this.address = address;
        this.dni = dni;
        this.phone = phone;
    }

    public SellerInput(){

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
}
