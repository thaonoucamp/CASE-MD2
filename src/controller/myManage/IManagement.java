package controller.myManage;

import java.util.List;

public interface IManagement<T> {

    void add(T t);

    void edit(String name);

    void delete(String name);

    void show();

}
