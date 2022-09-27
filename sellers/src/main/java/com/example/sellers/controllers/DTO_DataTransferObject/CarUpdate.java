package com.example.sellers.controllers.DTO_DataTransferObject;

import com.example.sellers.domain.Car;
import com.example.sellers.domain.CarStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CarUpdate {
    @NotNull(message = "Attribute is null.")
    @NotBlank(message = "Attribute is empty.")
    private String brand, model;
    private CarStatus status;

    public CarUpdate(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.status = CarStatus.onSale;
    }

    public CarUpdate() {
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

    public CarStatus getStatus() {
        return status;
    }

    public void setStatus(CarStatus status) {
        this.status = status;
    }

    public Car toDomain(String numPlate) {
        return new Car(this.brand, this.model, numPlate);
    }
}
