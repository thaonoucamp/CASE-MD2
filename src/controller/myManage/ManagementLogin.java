package controller.myManage;

import model.product.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagementLogin {
    transient Scanner sc = new Scanner(System.in);
    String[] admin = {"admin", "123456"};
    private List<Account> accountList;

    public List<Account> getAccountList() {
        return accountList;
    }

    public ManagementLogin() {
        accountList = new ArrayList<>();
    }

    public void checkAccountStaff() {
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

    public Account registration() {
        Account newAccount = new Account();

        System.out.println("Enter the account");
        newAccount.setAccount(sc.nextLine());

        System.out.println("Enter the password");
        newAccount.setPassword(sc.nextLine());

        return newAccount;
    }

    public boolean checkAccountCus(Account account) {
        account = registration();
        for (int i = 0; i <= this.getAccountList().size(); i++) {
            if (!account.getAccount().equalsIgnoreCase(this.getAccountList().get(i).getAccount())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
