package com.example.sellers.controllers.JSONClients;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClientOutput {

    @NotNull(message = "Attribute is null.")
    @NotBlank(message = "Attribute is empty.")
    private String name, dni;
    @Digits(message = "Phone invalid", integer = 9, fraction = 0)
    private int phone;

    public ClientOutput(String name, String dni, int phone) {
        this.name = name;
        this.dni = dni;
        this.phone = phone;
    }

    public ClientOutput() {
    }

    public String getName() {
        return name;
    }

    public String getDni() {
        return dni;
    }

    public int getPhone() {
        return phone;
    }
}
