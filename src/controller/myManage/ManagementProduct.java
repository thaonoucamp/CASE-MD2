package controller.myManage;

import controller.myFile.FileIO;
import model.product.Product;

import java.io.IOException;
import java.util.*;

public class ManagementProduct implements IManagement<Product> {
    transient Scanner sc = new Scanner(System.in);
    private List<Product> productList;
    FileIO fileProduct = new FileIO();

    public ManagementProduct() {
        try {
            productList = fileProduct.readByCSV(fileProduct.FILE_PRODUCT);
        } catch (Exception e) {
            productList = new ArrayList<>();
        }
        productList.add(new Product("Iphone X", "Apple", 10));
        productList.add(new Product("Iphone 12", "Apple", 20));
        productList.add(new Product("Galaxy Fold", "Sam sung", 15));
        productList.add(new Product("Galaxy Note", "Sam sung", 10));
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
    public void add(Product product) throws IOException {
        for (int i = 0; i < this.getProductList().size(); i++) {
            this.getProductList().add(product);
        }
        fileProduct.writeByCSV(fileProduct.FILE_PRODUCT, this.getProductList());
    }

    @Override
    public void edit(String name) throws IOException, ClassNotFoundException {
        fileProduct.readByCSV(fileProduct.FILE_PRODUCT);

        fileProduct.writeByCSV(fileProduct.FILE_PRODUCT, this.getProductList());
    }

    @Override
    public void delete(String name) throws IOException, ClassNotFoundException {
        fileProduct.readByCSV(fileProduct.FILE_PRODUCT);

        fileProduct.writeByCSV(fileProduct.FILE_PRODUCT, this.getProductList());
    }

    @Override
    public void show() {
        Iterator iterator = this.productList.iterator();
        while (iterator.hasNext()) {
            Product product = (Product) iterator.next();
            System.out.println(product);
        }
    }
}
