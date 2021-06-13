package controller.myManage;

import model.people.Customer;
import model.product.Bill;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagementBill implements IManagement<Bill> {
    transient Scanner sc = new Scanner(System.in);
    private List<Bill> billList;

    public ManagementBill() {
        billList = new ArrayList<>();
    }


    @Override
    public void add(Bill bill) {

    }

    @Override
    public void edit(String name) {

    }

    @Override
    public void delete(String name) {

    }

    @Override
    public void show() {

    }
}
