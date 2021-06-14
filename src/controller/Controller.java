package controller;

import controller.myFile.FileIO;
import controller.myManage.*;
import model.people.Customer;
import model.product.Account;
import model.product.Bill;
import model.product.Cart;
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

    public void viewProduct() throws IOException, ClassNotFoundException {
        int choice;
        do {
            System.out.println("-----VIEW PRODUCT-----" +
                    "\n1 -> Find by the price" +
                    "\n2 -> Find by the firm" +
                    "\n3 -> Find by the name" +
                    "\n4 -> Show the product all" +
                    "\n5 -> Previous to the Menu"
            );
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> findByPrice();
                case 2 -> findByFirm();
                case 3 -> findByName();
                case 4 -> this.getManagementProduct().show();
                case 5 -> this.menu();
            }
        } while (choice != -1);
    }

    public void findByName() throws IOException, ClassNotFoundException {
        Product product = null;
        int index = getIndex(this.managementProduct.getProductList());
        for (int i = 0; i < this.managementProduct.getProductList().size(); i++) {
            System.out.println(this.managementProduct.getProductList().get(index));
            product = this.managementProduct.getProductList().get(index);
            break;
        }
        optionOfCus(product);
    }

    public void findByFirm() throws IOException, ClassNotFoundException {
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
        optionForFind();
    }


    public void findByPrice() throws IOException, ClassNotFoundException {
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

    private void optionForFind() throws IOException, ClassNotFoundException {
        int choice = 0;
        System.out.println("-----OPTION------" +
                "\n1 -> Find by name" +
                "\n2 -> Previous to view product all" +
                "\n3 -> Previous to the Menu"
        );
        choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1 -> findByName();
            case 2 -> viewProduct();
            case 3 -> this.menu();
        }
    }

    public void optionOfCus(Product product) throws IOException, ClassNotFoundException {
        int choice;
        System.out.println("-----OPTION-----" +
                "\n1 -> Add to cart" +
                "\n2 -> Previous view product all" +
                "\n3 -> Previous to the Menu"
        );
        choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1 -> this.managementCart.add(product);
            case 2 -> this.viewProduct();
            case 3 -> this.menu();
        }
    }

    public void printBill(Bill bill) {
        System.out.println(bill.getCustomer());
        System.out.println(bill.getProducts());
        System.out.println(bill.getTotal());
    }

    public void payForProduct() throws IOException, ClassNotFoundException {
        try {
            Customer customer = Customer.getCustomer();
            Bill bill = Bill.getBill();
            long damage = 0;
            List<Product> cart = new ArrayList<>();
            for (int i = 0; i < this.getManagementCus().getCustomerList().size(); i++) {
                bill.setCustomer(this.getManagementCus().getCustomerList().get(i));
                cart = this.getManagementCart().getCart();
                bill.setProducts((ArrayList<Product>) cart);
                for (int j = 0; j < cart.size(); j++) {
                    String name_1 = cart.get(j).getName();
                    System.out.println("Enter the name of Product");
                    String name_2 = sc.nextLine();
                    if (name_1.equalsIgnoreCase(name_2)) {
                        damage = cart.get(j).getPrice();
                        bill.setTotal(damage);
                        this.getManagementCart().delete(name_1);
                        customer = this.getManagementCus().getCustomerList().get(i);
                        customer.setWallet(customer.getWallet() - damage);
                        break;
                    }
                }
            }
            System.out.println("Paid success...thanks !");
            this.printBill(bill);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.menu();
        }
    }

    public void pay() throws IOException, ClassNotFoundException {
        try {
            System.out.println(this.getManagementCart().getCart());
            int choice;
            System.out.println("-----OPTION FOR PAY-----" +
                    "\n1 -> Pay for one Product" +
                    "\n2 -> Pay for product all of cart"
            );
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> payForProduct();
                case 2 -> payCartAll();
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            this.menu();
        }
    }

    public void payCartAll() throws IOException, ClassNotFoundException {
        try {
            Bill bill = Bill.getBill();
            long damage = 0;
            Customer customer = Customer.getCustomer();
            for (int i = 0; i < this.getManagementCus().getCustomerList().size(); i++) {
                customer = this.getManagementCus().getCustomerList().get(i);
                bill.setCustomer(customer);
                List<Product> cart = this.getManagementCart().getCart();
                bill.setProducts((List<Product>) cart);
                for (int j = 0; j < cart.size(); j++) {
                    damage += cart.get(j).getPrice();
                    String name = cart.get(j).getName();
                    bill.setTotal(damage);
                    this.getManagementCart().delete(name);
                    this.getManagementCus().getCustomerList().get(i).setWallet(customer.getWallet() - damage);
                    break;
                }
            }
            System.out.println("Paid success...thanks !");
            this.printBill(bill);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.menu();
        }
    }

    public void showOneProduct(List<Product> list) {
        for (Product pro :
                list) {
            System.out.println(pro);
        }
    }

    public void login() throws IOException, ClassNotFoundException {
        if (this.checkAccountCus()) {
            this.viewProduct();
        }
    }

    public boolean checkAccountCus() {
        Customer customer = Customer.getCustomer();
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
            if (account.equalsIgnoreCase(ac) && pass.equalsIgnoreCase(pw)) {
                customer = this.getManagementCus().getCustomerList().get(i);
                System.out.println("Welcome to the " + name + " !");
                return true;
            }
        }
        System.out.println("The account or password is not right !");
        return false;
    }

    public void menu() throws IOException, ClassNotFoundException {
        Customer customer = Customer.getCustomer();
        int choice;
        do {
            System.out.println("-----MENU-----" +
                    "\n1 -> Login" +
                    "\n2 -> Registration " +
                    "\n3 -> Pay for Product " +
                    "\n0 -> Exit"
            );
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> this.login();
                case 2 -> this.getManagementCus().add(this.getManagementCus().inputInfoCus());
                case 3 -> this.pay();
                case 0 -> System.exit(0);
            }
        } while (choice != -1);
    }
}
