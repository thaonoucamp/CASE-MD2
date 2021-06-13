package controller.myFile;

import model.people.Customer;
import model.product.Bill;
import model.product.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
    public final String FILE_CUSTOMER = "/Users/thaodangxuan/IdeaProjects/CASE-MD2/src/controller/myFile/customer.dat";
    public final String FILE_CART = "/Users/thaodangxuan/IdeaProjects/CASE-MD2/src/controller/myFile/cart.csv";
    public final String FILE_PRODUCT = "/Users/thaodangxuan/IdeaProjects/CASE-MD2/src/controller/myFile/product.csv";
    public final String FILE_BILL = "/Users/thaodangxuan/IdeaProjects/CASE-MD2/src/controller/myFile/bill.dat";

    public void writeByCSV(String filePath, List<Product> list) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(list.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close();
    }

    public List<Product> readByCSV(String content) throws IOException, ClassNotFoundException {
        List<Product> list = new ArrayList<>();
        FileReader fileReader = new FileReader(content);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        Product product = Product.getProduct();
        while ((line = bufferedReader.readLine()) != null) {
            String[] item = line.split(",");
            product.setName(item[0]);
            product.setFirm(item[1]);
            product.setPrice(Long.parseLong(item[2]));
            list.add(product);
        }
        bufferedReader.close();
        fileReader.close();
        return list;
    }

    public void writeForCus(String filePath, List<Customer> list) throws IOException {
        FileOutputStream fo = new FileOutputStream(filePath);
        ObjectOutputStream oo = new ObjectOutputStream(fo);
        oo.writeObject(list);
        oo.close();
        fo.close();
    }

    public ArrayList<Customer> readForCus(String content) throws IOException, ClassNotFoundException {
        ArrayList<Customer> list = new ArrayList<>();
        FileInputStream fi = new FileInputStream(content);
        ObjectInputStream oi = new ObjectInputStream(fi);
        list = (ArrayList<Customer>) oi.readObject();
        oi.close();
        fi.close();
        return list;
    }

    public void writeForBill(String filePath, List<Bill> list) throws IOException {
        FileOutputStream fo = new FileOutputStream(filePath);
        ObjectOutputStream oo = new ObjectOutputStream(fo);
        oo.writeObject(list);
        oo.close();
        fo.close();
    }

    public ArrayList<Bill> readForBill(String content) throws IOException, ClassNotFoundException {
        ArrayList<Bill> list = new ArrayList<>();
        FileInputStream fi = new FileInputStream(content);
        ObjectInputStream oi = new ObjectInputStream(fi);
        list = (ArrayList<Bill>) oi.readObject();
        oi.close();
        fi.close();
        return list;
    }
}
