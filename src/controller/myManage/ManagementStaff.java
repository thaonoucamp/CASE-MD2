package controller.myManage;

import data_system.people.Staff;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagementStaff implements IManagement<Staff> {
    transient Scanner sc = new Scanner(System.in);
    List<Staff> staffList;

    public ManagementStaff() {
        staffList = new ArrayList<>();
    }

    @Override
    public Staff input() {
        Staff newStaff = Staff.getStaff();

        System.out.println("Enter the name by form [Nguyen Phu Trong]");
        String name = sc.nextLine();
        while (true) {
            if (Validate.validate(Validate.REGEX_NAME, name)) {
                newStaff.setName(name);
                break;
            } else {
                System.err.println("Enter be right with regex");
            }
        }

        System.out.println("Enter the birthday by form[31-12-2021]");
        String born = sc.nextLine();
        while (true) {
            if (Validate.validate(Validate.REGEX_BORN, born)) {
                newStaff.setAge(born);
                break;
            } else {
                System.err.println("Enter be right with regex");
            }
        }

        System.out.println("Enter the gender by form [nam -> 9, nu -> 0]");
        String gen = sc.nextLine();
        while (true) {
            if (Validate.validate(Validate.REGEX_GEN, gen)) {
                newStaff.setGender(gen);
                break;
            } else {
                System.err.println("Enter be right with regex");
            }
        }

        System.out.println("Enter the email by form [abc@gamil.com]");
        String email = sc.nextLine();
        while (true) {
            if (Validate.validate(Validate.REGEX_EMAIL, email)) {
                newStaff.setEmail(email);
                break;
            } else {
                System.err.println("Enter be right with regex");
            }
        }

        System.out.println("Enter the kip by form [AM|PM]");
        String kip = sc.nextLine();
        while (true) {
            if (Validate.validate(Validate.REGEX_KIP, kip)) {
                newStaff.setKip((kip));
                break;
            } else {
                System.err.println("Enter be right with regex");
            }
        }
        return null;
    }

    @Override
    public void add() {

    }

    @Override
    public void edit(String object) {

    }

    @Override
    public void delete(String object) {

    }

    @Override
    public void sort(List<Staff> list) {

    }

    @Override
    public void show(List<Staff> list) {

    }

    @Override
    public Staff find(String object) {
        return null;
    }

    @Override
    public void menu() {

    }
}