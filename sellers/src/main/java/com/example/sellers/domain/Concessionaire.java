package com.example.sellers.domain;


import com.example.sellers.domain.personalExceptions.*;

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

    public static void addSeller(Seller seller) throws SellerExistsException {
        if (listSellers.containsKey(seller.getDni())) throw new SellerExistsException("DNI ya existente");
        listSellers.put(seller.getDni(), seller);
    }

    public static void deleteSeller(String dni) throws SellerNotFoundException {
        if (!listSellers.containsKey(dni)) throw new SellerNotFoundException("No existe el vendedor introducido.");
        listSellers.remove(dni);
    }

    public static void updateSeller(Seller seller) throws SellerNotFoundException {
        if (!listSellers.containsKey(seller.getDni()))
            throw new SellerNotFoundException("No existe el vendedor introducido.");
        listSellers.put(seller.getDni(), seller);
    }

    public static void addClient(Client client) throws ClientExistsException {
        if (listClients.containsKey(client.getDni())) throw new ClientExistsException("DNI ya existente");
        listClients.put(client.getDni(), client);
    }

    public static void deleteClient(String dni) throws ClientNotFoundException {
        if (!listClients.containsKey(dni)) throw new ClientNotFoundException("No existe el vendedor introducido.");
        listClients.remove(dni);
    }

    public static void updateClient(Client client) throws ClientNotFoundException {
        if (!listClients.containsKey(client.getDni()))
            throw new ClientNotFoundException("No existe el cliente introducido.");
        listClients.put(client.getDni(), client);
    }

    public static void addCar(Car car) throws CarExistsException {
        if (listCars.containsKey(car.getNumPlate())) throw new CarExistsException("Matricula ya existente");
        listCars.put(car.getNumPlate(), car);
    }

    public static void deleteCar(String numPlate) throws CarNotFoundException {
        if (!listCars.containsKey(numPlate)) throw new CarNotFoundException("No existe el coche introducido.");
        listCars.remove(numPlate);
    }

    public static void updateCar(Car car) throws CarNotFoundException {
        if (!listCars.containsKey(car.getNumPlate()))
            throw new CarNotFoundException("No existe el coche introducido.");
        listCars.put(car.getNumPlate(), car);
    }

    public static void bookCar(String dni, String numPlate) throws CarNotFoundException, ClientNotFoundException, StatusIncorrectException {
        if (!listCars.containsKey(numPlate)) throw new CarNotFoundException("El coche no existe");
        if (!listClients.containsKey(dni)) throw new ClientNotFoundException("El cliente no existe");
        Client client = listClients.get(dni);
        Car car = listCars.get(numPlate);
        if (car.getStatus() != CarStatus.onSale) throw new StatusIncorrectException();
        car.setStatus(CarStatus.booked);
        client.getListBookCars().put(car.getNumPlate(), car);
    }

    public static void deleteBookCar(String dni, String numPlate) throws CarNotFoundException, ClientNotFoundException, StatusIncorrectException, BookingNotFoundException {
        if (!listCars.containsKey(numPlate)) throw new CarNotFoundException("El coche no existe");
        if (!listClients.containsKey(dni)) throw new ClientNotFoundException("El cliente no existe");
        Client client = listClients.get(dni);
        Car car = listCars.get(numPlate);
        if (client.getListBookCars().isEmpty()) throw new BookingNotFoundException("No hay coches reservados");
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
