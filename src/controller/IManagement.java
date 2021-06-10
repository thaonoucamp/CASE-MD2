package controller;

import java.util.List;

public interface IManagement<T> {
    T input();

    void add();

    void edit(String object);

    void delete(String object);

    void sort(List<T> list);

    T find(String object);

    void menu();
}
