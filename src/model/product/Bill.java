package model.product;

import model.people.Customer;
import model.people.Staff;

import java.io.Serializable;
import java.util.Date;

public class Bill implements Serializable {
    private static Bill INSTANCE = new Bill();

    public static Bill getBill() {
        return INSTANCE;
    }

    private Bill() {
        idBill++;
    }

    private int idBill = 0;
    private Customer customer;
    private Product product;
    private Staff staff;
    private int quantity;
    private long total;

    public Bill(Customer customer, Product product, Staff staff, int quantity, long total) {
        this.customer = customer;
        this.product = product;
        this.staff = staff;
        this.quantity = quantity;
        this.total = total;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIdBill() {
        return idBill;
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
                ", quantity=" + quantity +
                ", total=" + total +
                ", staff=" + staff +
                '}';
    }
}
