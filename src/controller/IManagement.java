package controller;

import java.util.List;

public interface IManagement<T> {
    T input();

    List<T> add();

    List<T> edit(List<T> list);

    List<T> delete(List<T> list);

    List<T> sort(List<T> list);

    List<T> find(List<T> list);

    void menu();
}
