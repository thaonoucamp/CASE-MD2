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

    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }

    Bill input() {
        Bill newBill = Bill.getBill();
        // code here;
        return newBill;
    }

    @Override
    public void add(Bill bill) {
        this.getBillList().add(input());
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
