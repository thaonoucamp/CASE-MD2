package model.people;

import model.product.Account;
import model.product.Cart;

public class Customer extends Person {
    private static Customer INSTANCE = new Customer();

    private Customer() {
        wallet = 100;
        cart = null;
    }

    public static Customer getCustomer() {
        return INSTANCE;
    }

    private String email;
    private long wallet;
    private Account account;
    private Cart cart;

    public Customer(String email, long wallet, Account account, Cart cart) {
        this.email = email;
        this.wallet = wallet;
        this.account = account;
        this.cart = cart;
    }

    public Customer(String name, String age, String gender, String email, long wallet, Account account, Cart cart) {
        super(name, age, gender);
        this.email = email;
        this.wallet = wallet;
        this.account = account;
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getWallet() {
        return wallet;
    }

    public void setWallet(long wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "Customer{" + super.getName() +
                ", wallet=" + wallet +
                ", cart=" + cart +
                '}';
    }
}
