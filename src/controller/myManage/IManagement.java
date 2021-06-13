package controller.myManage;

import java.io.IOException;
import java.util.List;

public interface IManagement<T> {

    void add(T t) throws IOException;

    void edit(String name) throws IOException, ClassNotFoundException;

    void delete(String name) throws IOException, ClassNotFoundException;

    void show();

}
