package view;

import controller.Controller;
import controller.myManage.ManagementLogin;
import controller.myManage.ManagementBill;
import controller.myManage.ManagementProduct;
import model.people.Customer;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.getLogin();
    }
}
