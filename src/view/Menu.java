package view;

import controller.myManage.ManagementLogin;
import controller.myManage.ManagementInfoBill;
import controller.myManage.ManagementProduct;

import java.util.Scanner;

public class Menu {
    transient Scanner sc = new Scanner(System.in);
    ManagementLogin managementLogin = new ManagementLogin();
    ManagementInfoBill managementInfoBill = new ManagementInfoBill();
    ManagementProduct managementProduct = new ManagementProduct();

    public void getLogin() {
        int choice;
        do {
            System.out.println("Who are you ?" +
                    "\n1 -> Staff" +
                    "\n2 -> View Product" +
                    "\n3 -> Registration " +
                    "\n0 -> Exit"
            );
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> managementLogin.checkAccountStaff();
                case 2 -> managementProduct.viewProduct();
                case 3 -> managementLogin.addAccount();
                case 0 -> System.exit(0);
            }
        } while (choice < 4 && choice > -1);
    }

}
