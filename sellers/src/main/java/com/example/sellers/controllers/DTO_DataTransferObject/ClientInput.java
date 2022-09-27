package com.example.sellers.controllers.DTO_DataTransferObject;

import com.example.sellers.domain.Client;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClientInput extends ClientUpdate{
    @NotNull(message = "DNI is null")
    @NotBlank(message = "DNI is empty")
    private String dni;

    public ClientInput(String name, String address, int phone, String dni) {
        super(name, address, phone);
        this.dni = dni;
    }

    public ClientInput(String dni) {
        this.dni = dni;
    }

    public Client toDomain() {
        return new Client(this.getName(), this.getAddress(), this.dni, this.getPhone());
    }
}
