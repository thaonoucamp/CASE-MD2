package controller.myManage;

import model.people.Customer;
import model.product.Product;

import java.util.*;

public class ManagementProduct implements IManagement<Product> {
    transient Scanner sc = new Scanner(System.in);
    private List<Product> productList;

    public ManagementProduct() {
        productList = new ArrayList<>();
        productList.add(new Product("Iphone X", "Apple", 10));
        productList.add(new Product("Galaxy Fold", "Sam sung",15));
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Product input() {
        Product newProduct = Product.getProduct();

        while (true) {
            System.out.println("Enter the name by form [Iphone 12 Pro Max]");
            String name = sc.nextLine();
            if (Validate.validate(Validate.REGEX_NAME, name)) {
                newProduct.setName(name);
                break;
            }
            System.err.println("Enter be right with regex");
        }

        while (true) {
            System.out.println("Enter the price by form[10.000.000]");
            String price = sc.nextLine();
            if (Validate.validate(Validate.REGEX_PRICE, price)) {
                newProduct.setPrice(Long.parseLong(price));
                break;
            }
            System.err.println("Enter be right with regex");
        }

        return null;
    }

    @Override
    public void add(Product product) {
        for (int i = 0; i < this.getProductList().size(); i++) {
            this.getProductList().add(product);
        }
    }

    @Override
    public void edit(String name) {
    }

    @Override
    public void delete(String name) {
    }

    @Override
    public void show() {
        Iterator iterator = this.productList.iterator();
        while (iterator.hasNext()) {
            Product product = (Product) iterator.next();
            System.out.println(product);
        }
    }

    public void menu() {

    }
}
