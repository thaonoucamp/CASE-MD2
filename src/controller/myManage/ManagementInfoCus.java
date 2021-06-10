package controller.myManage;

import data_system.people.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagementInfoCus implements IManagement<Customer> {
    private List<Customer> customerList;
    transient Scanner sc = new Scanner(System.in);

    public ManagementInfoCus() {
        customerList = new ArrayList<>();
    }

    @Override
    public Customer input() {
        Customer newCus = Customer.getInstance();

        System.out.println("Enter the name by form [Nguyen Phu Trong]");
        String name = sc.nextLine();
        while (true) {
            if (Validate.validate(Validate.REGEX_NAME, name)) {
                newCus.setName(name);
                break;
            } else {
                System.err.println("Enter be right with regex");
            }
        }

        System.out.println("Enter the birthday by form[31-12-2021]");
        String born = sc.nextLine();
        while (true) {
            if (Validate.validate(Validate.REGEX_BORN, born)) {
                newCus.setAge(born);
                break;
            } else {
                System.err.println("Enter be right with regex");
            }
        }

        System.out.println("Enter the gender by form [nam -> 9, nu -> 0]");
        String gen = sc.nextLine();
        while (true) {
            if (Validate.validate(Validate.REGEX_GEN, gen)) {
                newCus.setGender(gen);
                break;
            } else {
                System.err.println("Enter be right with regex");
            }
        }

        System.out.println("Enter the email by form [abc@gamil.com]");
        String email = sc.nextLine();
        while (true) {
            if (Validate.validate(Validate.REGEX_EMAIL, email)) {
                newCus.setEmail(email);
                break;
            } else {
                System.err.println("Enter be right with regex");
            }
        }

        System.out.println("Enter the money by form [1.000.000.000 ]");
        String wallet = sc.nextLine();
        while (true) {
            if (Validate.validate(Validate.REGEX_WALLET, wallet)) {
                newCus.setWallet(Long.parseLong(wallet));
                break;
            } else {
                System.err.println("Enter be right with regex");
            }
        }

        System.out.println("Enter the telephone by form [0983.456.789]");
        String telephone = sc.nextLine();
        while (true) {
            if (Validate.validate(Validate.REGEX_TELEPHONE, telephone)) {
                newCus.setTelephone(telephone);
                break;
            } else {
                System.err.println("Enter be right with regex");
            }
        }

        System.out.println("Enter the address by form [Ha Noi]");
        String address = sc.nextLine();
        while (true) {
            if (Validate.validate(Validate.REGEX_ADDRESS, address)) {
                newCus.setAddress(address);
                break;
            } else {
                System.err.println("Enter be right with regex");
            }
        }

        System.out.println("Enter the code customer by form [C0321(K|G|I)3]");
        String id = sc.nextLine();
        while (true) {
            if (Validate.validate(Validate.REGEX_ID, id)) {
                newCus.setIdCus(id);
                break;
            } else {
                System.err.println("Enter be right with regex");
            }
        }
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
    public void show(List<Customer> list) {

    }

    @Override
    public Customer find(String customer) {
        return null;
    }

    @Override
    public void menu() {

    }
}
