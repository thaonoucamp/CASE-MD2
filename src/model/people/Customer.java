package model.people;

import model.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {
    private static Customer INSTANCE = new Customer();

    private Customer() {
        this.wallet = 1000000000;
    }

    public static Customer getInstance() {
        return INSTANCE;
    }

    private String idCus;
    private String telephone;
    private String email;
    private long wallet;

    public Customer(String idCus, String email, long wallet) {
        this.idCus = idCus;
        this.email = email;
        this.wallet = wallet;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Customer(String idCus, String telephone, String email, long wallet) {
        this.idCus = idCus;
        this.telephone = telephone;
        this.email = email;
        this.wallet = wallet;
    }

    public Customer(String name, String age, String gender, String address, String idCus, String telephone, String email, long wallet) {
        super(name, age, gender, address);
        this.idCus = idCus;
        this.telephone = telephone;
        this.email = email;
        this.wallet = wallet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCus() {
        return idCus;
    }

    public void setIdCus(String idCus) {
        this.idCus = idCus;
    }

    public long getWallet() {
        return wallet;
    }

    public void setWallet(long wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "Customer{" + super.toString() +
                ", idCus='" + idCus + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", wallet=" + wallet +
                ", cart=" + cart +
                '}';
    }
}
