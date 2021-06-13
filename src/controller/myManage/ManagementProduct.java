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


        while (true) {
            System.out.println("Enter the firm by form [Apple]");
            String firm = sc.nextLine();
            if (Validate.validate(Validate.REGEX_ADDRESS, firm)) {
                newProduct.setFirm(firm);
                break;
            }
            System.err.println("Enter be right with regex");
        }
        return null;
    }

    @Override
    public void add(Product product) {

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
