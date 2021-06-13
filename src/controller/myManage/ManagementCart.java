package controller.myManage;

import model.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ManagementCart implements IManagement<Product> {
   private List<Product> cart;

    public List<Product> getCart() {
        return cart;
    }

    public ManagementCart() {
        cart = new ArrayList<>();
    }


    public void add(Product product) {
        this.cart.add(product);
        System.out.println("The product has added the Cart");
        show();
    }

    @Override
    public void edit(String name) {

    }

    @Override
    public void delete(String name) {
        int index = 0;
        for (int i = 0; i < this.getCart().size(); i++) {
            this.getCart().remove(index);
            System.out.println("Paid success...Thanks !");
            break;
        }
    }

    @Override
    public void show() {
        Iterator iterator = this.cart.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public void menu() {

    }
}
