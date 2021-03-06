package controller.myManage;

import model.people.Staff;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagementStaff implements IManagement<Staff> {
    transient Scanner sc = new Scanner(System.in);
    Staff staff = null;
    List<Staff> staffList;

    public ManagementStaff() {
        staffList = new ArrayList<>();
    }

    public Staff input() {
        Staff newStaff = Staff.getStaff();

        while (true) {
            System.out.println("Enter the name by form [Nguyen Phu Trong]");
            String name = sc.nextLine();
            if (Validate.validate(Validate.REGEX_NAME, name)) {
                newStaff.setName(name);
                break;
            }
            System.err.println("Enter be right with regex");

        }

        while (true) {
            System.out.println("Enter the birthday by form[31-12-2021]");
            String born = sc.nextLine();
            if (Validate.validate(Validate.REGEX_BORN, born)) {
                newStaff.setAge(born);
                break;
            }
            System.err.println("Enter be right with regex");
        }

        while (true) {
            System.out.println("Enter the gender by form [nam -> 9, nu -> 0]");
            String gen = sc.nextLine();
            if (Validate.validate(Validate.REGEX_GEN, gen)) {
                newStaff.setGender(gen);
                break;
            }
            System.err.println("Enter be right with regex");
        }

        while (true) {
            System.out.println("Enter the email by form [abc@gamil.com]");
            String email = sc.nextLine();
            if (Validate.validate(Validate.REGEX_EMAIL, email)) {
                newStaff.setEmail(email);
                break;
            }
            System.err.println("Enter be right with regex");
        }
        return newStaff;
    }

    @Override
    public void add(Staff staff) {

    }

    @Override
    public void edit(String name) {

    }

    @Override
    public void delete(String name) {

    }

    @Override
    public void show() {

    }
}