package controller;

import controller.myManage.*;
import model.people.Customer;
import model.product.Account;
import model.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    transient Scanner sc = new Scanner(System.in);
    private ManagementCart cart;
    private ManagementProduct managementProduct;
    private ManagementStaff managementStaff;
    private ManagementLogin managementLogin;
    private ManagementBill managementBill;

    public ManagementCart getCart() {
        return cart;
    }

    public ManagementProduct getManagementProduct() {
        return managementProduct;
    }

    public ManagementStaff getManagementStaff() {
        return managementStaff;
    }

    public ManagementLogin getManagementLogin() {
        return managementLogin;
    }

    public ManagementBill getManagementBill() {
        return managementBill;
    }

    public Controller() {
        cart = new ManagementCart();
        managementProduct = new ManagementProduct();
        managementStaff = new ManagementStaff();
        managementLogin = new ManagementLogin();
        managementBill = new ManagementBill();
        cart = new ManagementCart();
    }


    public int getIndex(List<Product> list) {
        System.out.println("Enter the name want to find");
        String name = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public void addAccount(model.people.Customer customer) {
        Customer account = this.registration();
        if (this.getManagementLogin().getAccountList().size() == 0) {
            this.getManagementLogin().getAccountList().add(account);
            System.out.println("Registration success !");
            this.menu(customer);
        } else {
            this.checkAccountCus(account);
            while (true) {
                if (this.checkAccountCus(account)) {
                    this.getManagementLogin().getAccountList().add(account);
                    System.out.println("Registration success !");
                    this.menu(customer);
                    break;
                } else {
                    System.err.println("The account is duplicate !");
                }
            }
        }
    }

    public void viewProduct(model.people.Customer customer) {
        int choice;
        do {
            System.out.println("-----VIEW PRODUCT-----" +
                    "\n1 -> find by the price" +
                    "\n2 -> find by the firm" +
                    "\n3 -> find by the name");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> findByPrice(customer);
                case 2 -> findByFirm(customer);
                case 3 -> findByName(customer);
            }
        } while (choice > 4 && choice < 1);
    }

    public void findByName(model.people.Customer customer) {
        Product product = null;
        int index = getIndex(this.managementProduct.getProductList());
        for (int i = 0; i < this.managementProduct.getProductList().size(); i++) {
            System.out.println(this.managementProduct.getProductList().get(index));
            product = this.managementProduct.getProductList().get(index);
            break;
        }
        optionOfCus(customer, product);
    }

    public void findByFirm(model.people.Customer customer) {
        List<Product> listFirm = new ArrayList<>();

        System.out.println("Enter the firm");
        String firm = sc.nextLine();

        for (int i = 0; i < this.managementProduct.getProductList().size(); i++) {
            if (managementProduct.getProductList().get(i).getFirm().equalsIgnoreCase(firm)) {
                listFirm.add(managementProduct.getProductList().get(i));
            }
        }
        showOneProduct(listFirm);
        optionForFind(customer);
    }


    public void findByPrice(model.people.Customer customer) {
        List<Product> listPrice = new ArrayList<>();

        System.out.println("Enter the price");
        long price = Long.parseLong(sc.nextLine());

        Product product;
        for (int i = 0; i < this.managementProduct.getProductList().size(); i++) {
            if (managementProduct.getProductList().get(i).getPrice() == price) {
                product = managementProduct.getProductList().get(i);
                listPrice.add(product);
            }
        }
        showOneProduct(listPrice);
        optionForFind(customer);
    }

    private void optionForFind(model.people.Customer customer) {
        int choice = 0;
        System.out.println("-----OPTION 2------" +
                "\n1 -> Find by name" +
                "\n2 -> Previous to view product all");
        choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1 -> findByName(customer);
            case 2 -> viewProduct(customer);
        }
    }

    public void optionOfCus(model.people.Customer customer, Product product) {
        int choice;
        System.out.println("-----OPTION 1-----" +
                "\n1 -> add to cart" +
                "\n2 -> pay for product");
        choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1 -> this.cart.add(product);
            case 2 -> payForProduct(customer, product);
        }
    }

    private void payForProduct(model.people.Customer customer, Product product) {
        long total = 0;
        total = customer.getWallet() - product.getPrice();
        customer.setWallet(customer.getWallet() - product.getPrice());
        this.cart.getCart().remove(product);
    }

    public void showOneProduct(List<Product> list) {
        for (Product pro :
                list) {
            System.out.println(pro);
        }
    }

    public void checkAccountStaff() {
        boolean check = true;
        do {
            String[] login = new String[2];
            System.out.print("Enter the account : ");
            String ac = sc.nextLine();
            System.out.print("Enter the password : ");
            String pw = sc.nextLine();

            login[0] = ac;
            login[1] = pw;

            for (int i = 0; i < login.length; i++) {
                if (login[i].equalsIgnoreCase(this.getManagementLogin().getAdmin()[i])) {
                    check = false;
                } else {
                    System.err.println("The account or password is not right");
                }
            }
        } while (check);
    }

    public Customer registration() {
        Customer newCustomer = this.getManagementLogin().inputInfoCus();
        return newCustomer;
    }

    public boolean checkAccountCus(Customer customer) {
        customer = registration();
        for (int i = 0; i <= this.getManagementLogin().getAccountList().size(); i++) {
            if (!customer.getAccount().getPhone().equalsIgnoreCase(this.getManagementLogin().getAccountList().get(i).getAccount().getPhone())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void menu(model.people.Customer customer) {
        customer = null;
        int choice;
        do {
            System.out.println("-----MENU-----" +
                    "\n1 -> Login" +
                    "\n2 -> View Product" +
                    "\n3 -> Registration " +
                    "\n0 -> Exit"
            );
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> this.checkAccountStaff();
                case 2 -> this.viewProduct(customer);
                case 3 -> this.addAccount(customer);
                case 0 -> System.exit(0);
            }
        } while (choice != -1);
    }
}
