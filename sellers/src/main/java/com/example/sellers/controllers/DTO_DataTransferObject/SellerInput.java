package com.example.sellers.controllers.DTO_DataTransferObject;

import com.example.sellers.domain.Seller;

import javax.validation.constraints.*;

public class SellerInput extends SellerUpdate {

    @NotNull(message = "DNI is null")
    @NotBlank(message = "DNI is empty")
    private String dni;

    public SellerInput(String name, String address, String dni, int phone) {
        super(name, address, phone);
        this.dni = dni;
    }

    public SellerInput() {

    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Seller toDomain() {
        return new Seller(this.getName(), this.getAddress(), this.getDni(), this.getPhone());
    }

}
