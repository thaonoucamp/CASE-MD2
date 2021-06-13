package model.product;

import model.people.Customer;

import java.util.Date;

public class Bill {
    private static Bill INSTANCE = new Bill();

    public static Bill getBill() {
        return INSTANCE;
    }

    private Bill() {
    }

    private int idBill;
    private Customer customer;
    private Product product;
    private int quantity;
    private long total;

    public Bill(int idBill, Customer customer, Product product, Date date, int quantity, long total) {
        this.idBill = idBill;
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
        this.total = total;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
                "idBill=" + idBill +
                ", product=" + product +
                ", customer=" + customer +
                ", total=" + total +
                '}';
    }
}
