package model.product;

public class Product {
    private static Product INSTANCE = new Product();

    public static Product getProduct() {
        return INSTANCE;
    }

    private String name;
    private String firm;
    private long price;


    public Product(String name, String firm, long price) {
        this.name = name;
        this.firm = firm;
        this.price = price;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    private Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", firm='" + firm + '\'' +
                ", price=" + price +
                '}';
    }
}
