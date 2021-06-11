package controller.myManage;

import java.util.List;

public interface IManagement<T> {
    T input();

    void add();

    void edit();

    void delete();

    void sort();

    void show();

    void find();

    void menu();
}
