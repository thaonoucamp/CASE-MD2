package model.product;

import model.people.Customer;
import model.people.Staff;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Bill implements Serializable {
    private static Bill INSTANCE = new Bill();

    public static Bill getBill() {
        return INSTANCE;
    }

    private Bill() {
        products = new ArrayList<>();
    }

    private Customer customer;
    private List<Product> products;
    private long total;

    public Bill(Customer customer, List<Product> products, long total) {
        this.customer = customer;
        this.products = products;
        this.total = total;
    }

    public Product getProducts() {
        return (Product) products;
    }

    public void setProducts(List<Product> products) {
        this.products = (List<Product>) products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Bill{" +
                ", product=" + products.toString() +
                ", customer=" + customer +
                ", total=" + total +
                '}';
    }
}
