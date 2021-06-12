package controller.myManage;

import model.people.Customer;
import model.product.Product;

import java.util.*;

public class ManagementProduct implements IManagement<Product> {
    transient Scanner sc = new Scanner(System.in);
    private List<Product> productList;
    ManagementCart managementCart = new ManagementCart();

    public ManagementProduct() {
        productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

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

    public void add() {
    }

    @Override
    public void add(Product product) {

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

    public void viewProduct(Customer customer) {
        int choice;
        do {
            System.out.println("1 -> find by the price" +
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

    public void findByName(Customer customer) {
        ManagementCart managementCart = new ManagementCart();
        int index = getIndex(this.getProductList());
        Customer cus = null;
        Product product = null;
        for (int i = 0; i < this.getProductList().size(); i++) {
            System.out.println(this.getProductList().get(index));
            product = this.getProductList().get(index);
            break;
        }
        optionOfCus(product, customer);
    }

    public void findByFirm(Customer customer) {
        List<Product> listFirm = new ArrayList<>();

        System.out.println("Enter the firm");
        String firm = sc.nextLine();

        for (int i = 0; i < this.productList.size(); i++) {
            if (productList.get(i).getFirm().equalsIgnoreCase(firm)) {
                listFirm.add(productList.get(i));
            }
        }
        showProduct(listFirm);
        optionForFind(customer);
    }


    public void findByPrice(Customer customer) {
        List<Product> listPrice = new ArrayList<>();

        System.out.println("Enter the firm");
        long price = Long.parseLong(sc.nextLine());

        Product product;
        for (int i = 0; i < this.productList.size(); i++) {
            if (productList.get(i).getPrice() == price) {
                product = this.productList.get(i);
                listPrice.add(product);
            }
        }
        showProduct(listPrice);
        optionForFind(customer);
    }

    private void optionForFind(Customer customer) {
        int choice = 0;
        System.out.println("Enter your choice continue ?" +
                "\n1 -> Find by name" +
                "\n2 -> Return to view product all");
        choice = Integer.parseInt(sc.nextLine());
        switch (choice){
            case 1 -> findByName(customer);
            case 2 -> viewProduct(customer);
        }
    }

    public void optionOfCus(Product product, Customer customer) {
        int choice;
        System.out.println("1 -> add to cart" +
                "\n2 -> pay for product");
        choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1 -> managementCart.add(product);
            case 2 -> payForProduct(product, customer);
        }
    }

    private void payForProduct(Product product, Customer customer) {
        long total = 0;
        total = customer.getWallet() - product.getPrice();
        customer.setWallet(customer.getWallet() - product.getPrice());
        managementCart.getCart().remove(product);
    }

    public void showProduct(List<Product> list) {
        for (Product pro :
                list) {
            System.out.println(pro);
        }
    }

    public void menu() {

    }
}
