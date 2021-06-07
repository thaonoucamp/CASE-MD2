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
    public List<Product> add() {
        return null;
    }

    @Override
    public List<Product> edit(List<Product> list) {
        return null;
    }

    @Override
    public List<Product> delete(List<Product> list) {
        return null;
    }

    @Override
    public List<Product> sort(List<Product> list) {
        return null;
    }

    @Override
    public List<Product> find(List<Product> list) {
        return null;
    }

    @Override
    public void menu() {

    }
}
