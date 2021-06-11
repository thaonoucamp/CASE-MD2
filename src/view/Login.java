package view;

import java.util.Scanner;

public class Login {
    transient Scanner sc = new Scanner(System.in);
    String[] admin = {"admin", "123456"};

    public Login() {
    }

    public void checkAccount() {
        boolean check = true;
        do {
            String[] login = new String[2];
            System.out.print("Enter the account : ");
            String ac = sc.nextLine();
            System.out.print("Enter the password : ");
            String pw = sc.nextLine();

            login[0] = ac;
            login[1] = pw;

            for (int i = 0; i < login.length; i++) {
                if (login[i].equalsIgnoreCase(this.admin[i])) {
                    check = false;
                } else {
                    System.err.println("The account or password is not right");
                }
            }
        } while (check);
    }
}
