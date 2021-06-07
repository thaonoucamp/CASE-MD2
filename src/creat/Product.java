package creat;

public class Product {
    private String name;
    private String firm;
    private long price;
    private String color;
    private boolean state;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Product(String name, String firm, long price, String color, boolean state) {
        this.name = name;
        this.firm = firm;
        this.price = price;
        this.color = color;
        this.state = state;
    }

    public Product() {
        state = false;
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
                ", color='" + state + '\'' +
                '}';
    }
}
