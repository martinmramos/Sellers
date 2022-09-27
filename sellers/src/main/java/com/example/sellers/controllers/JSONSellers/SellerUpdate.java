package com.example.sellers.controllers.JSONSellers;

import com.example.sellers.domain.Seller;

import javax.validation.constraints.*;

public class SellerUpdate {

    @NotNull(message = "Name is null")
    @NotBlank(message = "Name is empty")
    private String name;
    @NotNull(message = "Address is null")
    @NotBlank(message = "Address is empty")
    private String address;
    @Digits(message = "Phone invalid", integer = 9, fraction = 0)
    private int phone;

    public SellerUpdate(String name, String address, int phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public SellerUpdate(){

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

    public Seller toDomain(String dni){
        return new Seller(this.getName(), this.getAddress(), dni, this.getPhone());
    }
}
