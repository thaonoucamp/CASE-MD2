package controller.myManage;

import model.people.Customer;
import model.product.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagementLogin implements IManagement<Customer> {
    transient Scanner sc = new Scanner(System.in);
    private String[] admin = {"admin", "123456"};
    private List<Customer> accountList;

    public String[] getAdmin() {
        return admin;
    }

    public List<Customer> getAccountList() {
        return accountList;
    }

    public ManagementLogin() {
        accountList = new ArrayList<>();
    }

    public Customer inputInfoCus() {
        Customer newCus = Customer.getCustomer();

        while (true) {
            System.out.println("Enter the name by form [Nguyen Phu Trong]");
            String name = sc.nextLine();
            if (Validate.validate(Validate.REGEX_NAME, name)) {
                newCus.setName(name);
                break;
            }
            System.err.println("Enter be right with regex");
        }

        while (true) {
            System.out.println("Enter the birthday by form[31-12-2021]");
            String born = sc.nextLine();
            if (Validate.validate(Validate.REGEX_BORN, born)) {
                newCus.setAge(born);
                break;
            }
            System.err.println("Enter be right with regex");
        }

        while (true) {
            System.out.println("Enter the gender by form [nam -> 9, nu -> 0]");
            String gen = sc.nextLine();
            if (Validate.validate(Validate.REGEX_GEN, gen)) {
                newCus.setGender(gen);
                break;
            }
            System.err.println("Enter be right with regex");
        }

        while (true) {
            System.out.println("Enter the email by form [abc@gamil.com]");
            String email = sc.nextLine();
            if (Validate.validate(Validate.REGEX_EMAIL, email)) {
                newCus.setEmail(email);
                break;
            }
            System.err.println("Enter be right with regex");
        }

        Account account = new Account();
        while (true) {
            System.out.println("Enter the telephone by form [0989.898.989]");
            String telephone = sc.nextLine();
            if (Validate.validate(Validate.REGEX_TELEPHONE, telephone)) {
                account.setPhone(telephone);
                break;
            }
            System.err.println("Enter be right with regex");
        }

        while (true) {
            System.out.println("Enter the password by form [123456]");
            String pass = sc.nextLine();
            if (Validate.validate(Validate.REGEX_PASSWORD, pass)) {
                account.setPassword(pass);
                break;
            }
            System.err.println("Enter be right with regex");
        }

        newCus.setAccount(account);

        return newCus;
    }

    @Override
    public void add(Customer customer) {

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
