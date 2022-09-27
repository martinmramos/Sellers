package com.example.sellers.controllers.JSONClients;

import com.example.sellers.domain.Client;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClientUpdate{
    @NotNull(message = "Name is null")
    @NotBlank(message = "Name is empty")
    private String name;
    @NotNull(message = "Address is null")
    @NotBlank(message = "Address is empty")
    private String address;
    @Digits(message = "Phone invalid", integer = 9, fraction = 0)
    private int phone;

    public ClientUpdate(String name, String address, int phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public ClientUpdate() {
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Client toDomain(String dni){
        return new Client(this.getName(), this.getAddress(), dni, this.getPhone());
    }
}
