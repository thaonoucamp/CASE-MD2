package controller;

import creat.Product;

import java.util.ArrayList;
import java.util.List;

public class ManagementProduct implements IManagement<Product>{
    List<Product> productList;
    int idBill;

    public ManagementProduct() {
        productList = new ArrayList<>();
        idBill = 1;
    }

    @Override
    public Product input() {
        return null;
    }

    @Override
    public void add() {
    }

    @Override
    public void edit(String name) {
    }

    @Override
    public void delete(String name) {
    }

    @Override
    public void sort(List<Product> list) {
    }

    @Override
    public Product find(String name) {
        return null;
    }

    @Override
    public void menu() {

    }
}
