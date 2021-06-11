package view;

import controller.myManage.ManagementInfoCus;
import controller.myManage.ManagementProduct;

import java.util.Scanner;

public class Menu {
    transient Scanner sc = new Scanner(System.in);
    Login login = new Login();
    ManagementInfoCus managementInfoCus = new ManagementInfoCus();
    ManagementProduct managementProduct = new ManagementProduct();

    public void getLogin() {
        int choice;
        do {
            System.out.println("Who are you ?" +
                    "\n1 -> Staff" +
                    "\n2 -> Customer" +
                    "\n3 -> Customer potential" +
                    "\n0 -> Exit"
            );
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> login.checkAccount();
                case 2 -> managementInfoCus.add();
                case 3 -> managementProduct.find();
                case 0 -> System.exit(0);
            }
        } while (choice < 4 && choice > -1);
    }

}
