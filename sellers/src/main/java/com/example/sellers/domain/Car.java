package com.example.sellers.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "cars")
public class Car {

    @NotNull(message = "Attribute is null.")
    @NotBlank(message = "Attibute is empty.")
    private String brand, model;
    @NotNull(message = "Attribute is null.")
    @NotBlank(message = "Attibute is empty.")
    @Id
    private String numPlate;
    private CarStatus status;

    public Car(String brand, String model, String numPlate) {
        this.brand = brand;
        this.model = model;
        this.numPlate = numPlate;
        this.status = CarStatus.onSale;
    }

    public Car() {
        this.status = CarStatus.onSale;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumPlate() {
        return numPlate;
    }

    public void setNumPlate(String numPlate) {
        this.numPlate = numPlate;
    }

    public CarStatus getStatus() {
        return status;
    }

    public void setStatus(CarStatus status) {
        this.status = status;
    }
}
