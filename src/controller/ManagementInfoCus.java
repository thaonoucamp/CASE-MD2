package controller;

import creat.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagementInfoCus implements IManagement<Customer>{
    private List<Customer> customerList;
    transient Scanner sc = new Scanner(System.in);

    public ManagementInfoCus() {
        customerList = new ArrayList<>();
    }

    @Override
    public Customer input() {
        Customer newCus = Customer.getInstance();

        System.out.println("Enter the name");
        newCus.setName(sc.nextLine());

        System.out.println("Enter the age");
        newCus.setAge(sc.nextLine());

        System.out.println("Enter the gender");
        newCus.setGender(sc.nextLine());

        System.out.println("Enter the email");
        newCus.setEmail(sc.nextLine());

        System.out.println("Enter the money");
        newCus.setWallet(Long.parseLong(sc.nextLine()));

        System.out.println("Enter the name");
        newCus.setName(sc.nextLine());

        System.out.println("Enter the name");
        newCus.setName(sc.nextLine());

        return newCus;
    }

    @Override
    public void add() {
    }

    @Override
    public void edit(String customer) {
    }

    @Override
    public void delete(String customer) {
    }

    @Override
    public void sort(List<Customer> list) {
    }

    @Override
    public Customer find(String customer) {
        return null;
    }

    @Override
    public void menu() {

    }
}
