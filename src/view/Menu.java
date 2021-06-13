package view;

import controller.Controller;
import model.people.Customer;

public class Menu {

    public static void main(String[] args) {
        Controller controller = new Controller();
        Customer customer = Customer.getCustomer();
        controller.menu(customer);
    }
}
