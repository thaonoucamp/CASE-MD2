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

    public void addAccount() {
        Account account = this.getManagementLogin().registration();
        if (this.getManagementLogin().getAccountList().size() == 0) {
            this.getManagementLogin().getAccountList().add(account);
            System.out.println("Registration success !");

        } else {
            this.getManagementLogin().checkAccountCus(account);
            while (true) {
                if (this.getManagementLogin().checkAccountCus(account)) {
                    this.getManagementLogin().getAccountList().add(account);
                    System.out.println("Registration success !");
                    break;
                } else {
                    System.err.println("The account is duplicate !");
                }
            }
        }
    }

    public void viewProduct() {
        int choice;
        do {
            System.out.println("1 -> find by the price" +
                    "\n2 -> find by the firm" +
                    "\n3 -> find by the name");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> findByPrice();
                case 2 -> findByFirm();
                case 3 -> findByName();
            }
        } while (choice > 4 && choice < 1);
    }

    public void findByName() {
        ManagementCart managementCart = new ManagementCart();
        int index = getIndex(this.managementProduct.getProductList());
        Customer cus = null;
        Product product = null;
        for (int i = 0; i < this.managementProduct.getProductList().size(); i++) {
            System.out.println(this.managementProduct.getProductList().get(index));
            product = this.managementProduct.getProductList().get(index);
            break;
        }
        optionOfCus(product);
    }

    public void findByFirm() {
        List<Product> listFirm = new ArrayList<>();

        System.out.println("Enter the firm");
        String firm = sc.nextLine();

        for (int i = 0; i < this.managementProduct.getProductList().size(); i++) {
            if (managementProduct.getProductList().get(i).getFirm().equalsIgnoreCase(firm)) {
                listFirm.add(managementProduct.getProductList().get(i));
            }
        }
        showOneProduct(listFirm);
        optionForFind();
    }


    public void findByPrice() {
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
        optionForFind();
    }

    private void optionForFind() {
        int choice = 0;
        System.out.println("Enter your choice continue ?" +
                "\n1 -> Find by name" +
                "\n2 -> Return to view product all");
        choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1 -> findByName();
            case 2 -> viewProduct();
        }
    }

    public void optionOfCus(Product product) {
        int choice;
        System.out.println("1 -> add to cart" +
                "\n2 -> pay for product");
        choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1 -> this.cart.add(product);
            case 2 -> payForProduct(product);
        }
    }

    private void payForProduct(Product product) {
        long total = 0;
//        total = customer.getWallet() - product.getPrice();
//        customer.setWallet(customer.getWallet() - product.getPrice());
        this.cart.getCart().remove(product);
    }

    public void showOneProduct(List<Product> list) {
        for (Product pro :
                list) {
            System.out.println(pro);
        }
    }

    public void getLogin() {
        int choice;
        do {
            System.out.println("-----MENU-----" +
                    "\n1 -> Staff" +
                    "\n2 -> View Product" +
                    "\n3 -> Registration " +
                    "\n0 -> Exit"
            );
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> this.getManagementLogin().checkAccountStaff();
                case 2 -> this.viewProduct();
                case 3 -> this.addAccount();
                case 0 -> System.exit(0);
            }
        } while (choice < 4 && choice > -1);
    }
}
