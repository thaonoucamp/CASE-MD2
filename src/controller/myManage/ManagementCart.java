package controller.myManage;

import controller.myFile.FileIO;
import model.product.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ManagementCart implements IManagement<Product> {
    private List<Product> cart;
    FileIO fileCart = new FileIO();

    public List<Product> getCart() {
        return cart;
    }

    public ManagementCart() {
        try {
            cart = fileCart.readByCSV(fileCart.FILE_PRODUCT);
        } catch (Exception e) {
            cart = new ArrayList<>();
        }
    }

    public void add(Product product) throws IOException {
        this.getCart().add(product);
        System.out.println("The product has added the Cart");
        fileCart.writeByCSV(fileCart.FILE_CART, this.getCart());
        show();
    }

    @Override
    public void edit(String name) throws IOException, ClassNotFoundException {
        fileCart.readByCSV(fileCart.FILE_CART);


        fileCart.writeByCSV(fileCart.FILE_CART, this.getCart());
        show();
    }

    @Override
    public void delete(String name) throws IOException, ClassNotFoundException {
        fileCart.readByCSV(fileCart.FILE_CART);
        for (int i = 0; i < this.getCart().size(); i++) {
            if (name.equalsIgnoreCase(this.getCart().get(i).getName()))
                this.getCart().remove(i);
            System.out.println("Remove success...Thanks !");
            break;
        }
        fileCart.writeByCSV(fileCart.FILE_CART, this.getCart());
        show();
    }

    @Override
    public void show() {
        Iterator iterator = this.cart.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
