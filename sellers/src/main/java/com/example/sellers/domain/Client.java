package com.example.sellers.domain;

import java.util.HashMap;

public class Client extends Person{

    private HashMap<String, Car> listBookCars = new HashMap<>();

    public Client(String name, String address, String dni, int phone) {
        super(name, address, dni, phone);
    }

    public Client() {
    }

    public HashMap<String, Car> getListBookCars() {
        return listBookCars;
    }
}
