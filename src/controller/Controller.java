package controller;

import controller.myFile.FileIO;
import controller.myManage.*;
import model.people.Customer;
import model.product.Account;
import model.product.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    transient Scanner sc = new Scanner(System.in);
    private ManagementCart managementCart;
    private ManagementProduct managementProduct;
    private ManagementStaff managementStaff;
    private ManagementCus managementCus;
    private ManagementBill managementBill;
    FileIO fileController = new FileIO();

    public ManagementCart getManagementCart() {
        return managementCart;
    }

    public ManagementProduct getManagementProduct() {
        return managementProduct;
    }

    public ManagementStaff getManagementStaff() {
        return managementStaff;
    }

    public ManagementCus getManagementCus() {
        return managementCus;
    }

    public ManagementBill getManagementBill() {
        return managementBill;
    }

    public Controller() {
        managementCart = new ManagementCart();
        managementProduct = new ManagementProduct();
        managementStaff = new ManagementStaff();
        managementCus = new ManagementCus();
        managementBill = new ManagementBill();
        managementCart = new ManagementCart();
    }

    public int getIndex(List<Product> list) {
        do {
            System.out.println("Enter the name want to find");
            String name = sc.nextLine();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getName().equalsIgnoreCase(name)) {
                    return i;
                }
            }
            System.err.println("Not find the product !");
            return -1;
        } while (true);
    }

    public void viewProduct(model.people.Customer customer) throws IOException {
        int choice;
        do {
            System.out.println("-----VIEW PRODUCT-----" +
                    "\n1 -> Find by the price" +
                    "\n2 -> Find by the firm" +
                    "\n3 -> Find by the name" +
                    "\n4 -> Previous to the Menu"
            );
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> findByPrice(customer);
                case 2 -> findByFirm(customer);
                case 3 -> findByName(customer);
                case 4 -> this.menu(customer);
            }
        } while (choice != -1);
    }

    public void findByName(model.people.Customer customer) throws IOException {
        Product product = null;
        int index = getIndex(this.managementProduct.getProductList());
        for (int i = 0; i < this.managementProduct.getProductList().size(); i++) {
            System.out.println(this.managementProduct.getProductList().get(index));
            product = this.managementProduct.getProductList().get(index);
            break;
        }
        optionOfCus(customer, product);
    }

    public void findByFirm(model.people.Customer customer) throws IOException {
        List<Product> listFirm = new ArrayList<>();
        Product product;

        System.out.println("Enter the firm");
        String firm = sc.nextLine();

        for (int i = 0; i < this.managementProduct.getProductList().size(); i++) {
            if (managementProduct.getProductList().get(i).getFirm().equalsIgnoreCase(firm)) {
                product = managementProduct.getProductList().get(i);
                listFirm.add(product);
            }
        }
        showOneProduct(listFirm);
        optionForFind(customer);
    }


    public void findByPrice(model.people.Customer customer) throws IOException {
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

    private void optionForFind(model.people.Customer customer) throws IOException {
        int choice = 0;
        System.out.println("-----OPTION 2------" +
                "\n1 -> Find by name" +
                "\n2 -> Previous to view product all" +
                "\n3 -> Previous to the Menu"
        );
        choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1 -> findByName(customer);
            case 2 -> viewProduct(customer);
            case 3 -> this.menu(customer);
        }
    }

    public void optionOfCus(model.people.Customer customer, Product product) throws IOException {
        int choice;
        System.out.println("-----OPTION 1-----" +
                "\n1 -> Add to cart" +
                "\n2 -> Previous view product all" +
                "\n3 -> Previous to the Menu"
        );
        choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1 -> this.managementCart.add(product);
            case 2 -> this.viewProduct(customer);
            case 3 -> this.menu(customer);
        }
    }

    private void payForProduct(Customer customer) {
        int index = this.getIndex(this.managementCart.getCart());
        Product product = this.managementCart.getCart().get(index);
        customer.setWallet(customer.getWallet() - product.getPrice());
        this.managementCart.getCart().remove(product);
    }

    public void showOneProduct(List<Product> list) {
        for (Product pro :
                list) {
            System.out.println(pro);
        }
    }

    public void login(Customer customer) {
        while (true) {
            if (this.checkAccountCus(customer)) {
                break;
            }
        }
    }

    public boolean checkAccountCus(Customer customer) {
        Account newAccount = new Account();

        System.out.print("Enter the account : ");
        String ac = sc.nextLine();
        newAccount.setPhone(ac);

        System.out.print("Enter the password : ");
        String pw = sc.nextLine();
        newAccount.setPassword(pw);

        for (int i = 0; i < this.getManagementCus().getCustomerList().size(); i++) {
            String account = this.getManagementCus().getCustomerList().get(i).getAccount().getPhone();
            String pass = this.getManagementCus().getCustomerList().get(i).getAccount().getPassword();
            String name = this.getManagementCus().getCustomerList().get(i).getName();
            customer = this.getManagementCus().getCustomerList().get(i);
            if (account.equalsIgnoreCase(ac) && pass.equalsIgnoreCase(pw)) {
                System.out.println("Welcome to the " + name + " !");
                return true;
            }
        }
        System.out.println("The account or password is not right !");
        return false;
    }

    public Customer registration() {
        Customer newCustomer = this.getManagementCus().inputInfoCus();
        return newCustomer;
    }

    public void menu(Customer customer) throws IOException {
        int choice;
        do {
            System.out.println("-----MENU-----" +
                    "\n1 -> Login" +
                    "\n2 -> View Product" +
                    "\n3 -> Registration " +
                    "\n4 -> View the Cart " +
                    "\n5 -> Pay for Product " +
                    "\n0 -> Exit"
            );
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> this.login(customer);
                case 2 -> this.viewProduct(customer);
                case 3 -> this.getManagementCus().add(this.getManagementCus().inputInfoCus());
                case 4 -> this.getManagementCart().show();
                case 5 -> this.payForProduct(customer);
                case 0 -> System.exit(0);
            }
        } while (choice != -1);
    }
}
