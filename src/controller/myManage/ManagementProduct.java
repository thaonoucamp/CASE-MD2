package controller.myManage;

import model.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ManagementProduct implements IManagement<Product> {
    transient Scanner sc = new Scanner(System.in);
    private List<Product> productList;

    public ManagementProduct() {
        productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public Product input() {
        Product newProduct = Product.getProduct();

        System.out.println("Enter the name by form [Iphone 12 Pro Max]");
        String name = sc.nextLine();
        while (true) {
            if (Validate.validate(Validate.REGEX_NAME, name)) {
                newProduct.setName(name);
                break;
            } else {
                System.err.println("Enter be right with regex");
            }
        }

        System.out.println("Enter the price by form[10.000.000]");
        String price = sc.nextLine();
        while (true) {
            if (Validate.validate(Validate.REGEX_PRICE, price)) {
                newProduct.setPrice(Long.parseLong(price));
                break;
            } else {
                System.err.println("Enter be right with regex");
            }
        }

        System.out.println("Enter the firm by form [Apple]");
        String firm = sc.nextLine();
        while (true) {
            if (Validate.validate(Validate.REGEX_ADDRESS, firm)) {
                newProduct.setFirm(firm);
                break;
            } else {
                System.err.println("Enter be right with regex");
            }
        }
        return null;
    }

    @Override
    public void add() {
    }

    @Override
    public void edit() {
    }

    @Override
    public void delete() {
    }

    @Override
    public void sort() {
    }

    @Override
    public void show() {
        Iterator iterator = this.productList.iterator();
        while (iterator.hasNext()) {
            Product product = (Product) iterator.next();
            System.out.println(product);
        }
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

    @Override
    public void find() {
        int choice;
        System.out.println("1 -> find by the price" +
                "\n2 -> find by the firm");
        choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1 -> findByPrice();
            case 2 -> findByFirm();
            case 3 -> findByName();
        }
    }

    private void findByName() {
        int index = getIndex(this.getProductList());
        for (int i = 0; i < this.getProductList().size(); i++) {
            System.out.println(this.getProductList().get(index));
        }
        paid();
    }

    public void findByFirm() {
        List<Product> listFirm = new ArrayList<>();

        System.out.println("Enter the firm");
        String firm = sc.nextLine();

        for (int i = 0; i < this.productList.size(); i++) {
            if (productList.get(i).getFirm().equalsIgnoreCase(firm)) {
                listFirm.add(productList.get(i));
            }
        }
        showProduct(listFirm);
        paid();
    }


    public void findByPrice() {
        List<Product> listPrice = new ArrayList<>();

        System.out.println("Enter the firm");
        long price = Long.parseLong(sc.nextLine());

        for (int i = 0; i < this.productList.size(); i++) {
            if (productList.get(i).getPrice() == price) {
                listPrice.add(productList.get(i));
            }
        }
        showProduct(listPrice);
        paid();
    }

    public void paid() {
        int choice;
        System.out.println("1 -> add to cart" +
                "2 -> pay for product");
        choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1 -> addToCart();
            case 2 -> payForProduct();
        }
    }

    private void addToCart() {

    }
    public void showProduct(List<Product> list) {
        for (Product pro :
                list) {
            System.out.println(pro);
        }
    }

    @Override
    public void menu() {

    }
}
