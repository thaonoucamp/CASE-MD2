package creat;

public class Product {
    private String name;
    private String firm;
    private long price;
    private String color;

    public Product(String name, String firm, long price, String color) {
        this.name = name;
        this.firm = firm;
        this.price = price;
        this.color = color;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", firm='" + firm + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
