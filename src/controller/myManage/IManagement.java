package controller.myManage;

import java.util.List;

public interface IManagement<T> {
    void add(T t);

    void edit();

    void delete();

    void sort();

    void show();

    void viewProduct();

}
