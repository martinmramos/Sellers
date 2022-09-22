package com.example.sellers.domain;

import com.example.sellers.controllers.SellerInput;
import com.example.sellers.controllers.SellerUpdate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Concessionaire {

    private static HashMap<String, Seller> listSellers = new HashMap<>();

    public static HashMap<String, Seller> getListSellers() {
        return listSellers;
    }

    public static void setListSellers(HashMap<String, Seller> listSellers) {
        Concessionaire.listSellers = listSellers;
    }

    public static void addSeller(Seller seller) throws ExceptionInvalidParameter {
        if (listSellers.containsKey(seller.getDni())) throw new ExceptionInvalidParameter("DNI ya existente");
        listSellers.put(seller.getDni(), seller);
    }

    public static void deleteSeller(String dni) throws ExceptionInvalidParameter {
        if (!listSellers.containsKey(dni)) throw new ExceptionInvalidParameter("No existe el vendedor introducido.");
        listSellers.remove(dni);
    }

    public static void updateSeller(String name, String address, String dni, int phone) throws ExceptionInvalidParameter {
        if (!listSellers.containsKey(dni)) throw new ExceptionInvalidParameter("No existe el vendedor introducido.");
        Seller seller = listSellers.get(dni);
        seller.updateInfo(name, address, phone);
    }

    public static List<Seller> viewSellersList() {
        ArrayList<Seller> viewList = new ArrayList<>();
        viewList.addAll(listSellers.values());
        return viewList;
    }
}
