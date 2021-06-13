package model.product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable {
    private List<Product> cart;

    public Cart() {
        cart = new ArrayList<>();
    }

    public List<Product> getCart() {
        return cart;
    }
}
