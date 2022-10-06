package com.example.sellers.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "booking")
public class Booking {

    @NotNull(message = "Attribute is null.")
    @NotBlank(message = "Attibute is empty.")
    @Id
    private String numPlate;
    private String dni;

    public Booking(String numPlate, String dni) {
        this.numPlate = numPlate;
        this.dni = dni;
    }

    public Booking() {
    }

    public String getNumPlate() {
        return numPlate;
    }

    public void setNumPlate(String numPlate) {
        this.numPlate = numPlate;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
