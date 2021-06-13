package model.product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> cart;

    public Cart() {
        cart = new ArrayList<>();
    }

    public List<Product> getCart() {
        return cart;
    }
}
