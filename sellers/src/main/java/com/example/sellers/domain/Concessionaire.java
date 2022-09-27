package com.example.sellers.domain;


import com.example.sellers.domain.personalExceptions.ExceptionInvalidParameter;
import com.example.sellers.domain.personalExceptions.StatusIncorrectException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Concessionaire {

    private static HashMap<String, Seller> listSellers = new HashMap<>();
    private static HashMap<String, Client> listClients = new HashMap<>();
    private static HashMap<String, Car> listCars = new HashMap<>();

    public static HashMap<String, Seller> getListSellers() {
        return listSellers;
    }

    public static void setListSellers(HashMap<String, Seller> listSellers) {
        Concessionaire.listSellers = listSellers;
    }

    public static HashMap<String, Client> getListClients() {
        return listClients;
    }

    public static HashMap<String, Car> getListCars() {
        return listCars;
    }

    public static void addSeller(Seller seller) throws ExceptionInvalidParameter {
        if (listSellers.containsKey(seller.getDni())) throw new ExceptionInvalidParameter("DNI ya existente");
        listSellers.put(seller.getDni(), seller);
    }

    public static void deleteSeller(String dni) throws ExceptionInvalidParameter {
        if (!listSellers.containsKey(dni)) throw new ExceptionInvalidParameter("No existe el vendedor introducido.");
        listSellers.remove(dni);
    }

    public static void updateSeller(Seller seller) throws ExceptionInvalidParameter {
        if (!listSellers.containsKey(seller.getDni()))
            throw new ExceptionInvalidParameter("No existe el vendedor introducido.");
        listSellers.put(seller.getDni(), seller);
    }

    public static void addClient(Client client) throws ExceptionInvalidParameter {
        if (listClients.containsKey(client.getDni())) throw new ExceptionInvalidParameter("DNI ya existente");
        listClients.put(client.getDni(), client);
    }

    public static void deleteClient(String dni) throws ExceptionInvalidParameter {
        if (!listClients.containsKey(dni)) throw new ExceptionInvalidParameter("No existe el vendedor introducido.");
        listClients.remove(dni);
    }

    public static void updateClient(Client client) throws ExceptionInvalidParameter {
        if (!listClients.containsKey(client.getDni()))
            throw new ExceptionInvalidParameter("No existe el cliente introducido.");
        listClients.put(client.getDni(), client);
    }

    public static void addCar(Car car) throws ExceptionInvalidParameter {
        if (listCars.containsKey(car.getNumPlate())) throw new ExceptionInvalidParameter("Matricula ya existente");
        listCars.put(car.getNumPlate(), car);
    }

    public static void deleteCar(String numPlate) throws ExceptionInvalidParameter {
        if (!listCars.containsKey(numPlate)) throw new ExceptionInvalidParameter("No existe el coche introducido.");
        listCars.remove(numPlate);
    }

    public static void updateCar(Car car) throws ExceptionInvalidParameter {
        if (!listCars.containsKey(car.getNumPlate()))
            throw new ExceptionInvalidParameter("No existe el coche introducido.");
        listCars.put(car.getNumPlate(), car);
    }

    public static void bookCar(String dni, String numPlate) throws ExceptionInvalidParameter, StatusIncorrectException {
        if (!listCars.containsKey(numPlate)) throw new ExceptionInvalidParameter("El coche no existe");
        if (!listClients.containsKey(dni)) throw new ExceptionInvalidParameter("El cliente no existe");
        Client client = listClients.get(dni);
        Car car = listCars.get(numPlate);
        if (car.getStatus() != CarStatus.onSale) throw new StatusIncorrectException();
        car.setStatus(CarStatus.booked);
        client.getListBookCars().put(car.getNumPlate(), car);
    }

    public static void deleteBookCar(String dni, String numPlate) throws ExceptionInvalidParameter, StatusIncorrectException {
        if (!listCars.containsKey(numPlate)) throw new ExceptionInvalidParameter("El coche no existe");
        if (!listClients.containsKey(dni)) throw new ExceptionInvalidParameter("El cliente no existe");
        Client client = listClients.get(dni);
        Car car = listCars.get(numPlate);
        if (client.getListBookCars().isEmpty()) throw new ExceptionInvalidParameter("No hay coches reservados");
        if (!client.getListBookCars().containsKey(numPlate)) throw new StatusIncorrectException();
        car.setStatus(CarStatus.onSale);
        client.getListBookCars().remove(numPlate);
    }

    public static List<Seller> viewSellersList() {
        ArrayList<Seller> viewList = new ArrayList<>();
        viewList.addAll(listSellers.values());
        return viewList;
    }

}
