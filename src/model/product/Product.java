package model.product;

public class Product {
    private static Product INSTANCE = new Product();

    public static Product getProduct() {
        return INSTANCE;
    }

    private String name;
    private String firm;
    private long price;
    private boolean state;
    private int vote;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Product(String name, String firm, long price, boolean state, int vote) {
        this.name = name;
        this.firm = firm;
        this.price = price;
        this.vote = vote;
        this.state = state;
    }

    private Product() {
       this.state = false;
       this.vote = 1;
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

    public int getColor() {
        return vote;
    }

    public void setColor(int color) {
        this.vote = color;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", firm='" + firm + '\'' +
                ", price=" + price +
                ", color='" + state + '\'' +
                ", color='" + vote + '\'' +
                '}';
    }
}
