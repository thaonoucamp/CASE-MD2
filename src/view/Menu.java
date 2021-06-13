package view;

import controller.Controller;
import model.people.Customer;

import java.io.IOException;

public class Menu {

    public static void main(String[] args) throws IOException {
        Controller controller = new Controller();
        Customer customer = Customer.getCustomer();
        controller.menu(customer);
    }
}
