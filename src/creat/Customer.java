package creat;

public class Customer extends Person {
    private static Customer INSTANCE = new Customer();

    private Customer() {
    }

    public static Customer getInstance() {
        return INSTANCE;
    }

    private String idCus;
    private String email;
    private long wallet;

    public Customer(String idCus, String email, long wallet) {
        this.idCus = idCus;
        this.email = email;
        this.wallet = wallet;
    }

    public Customer(String name, String age, String gender, String address, String idCus, String email, long wallet) {
        super(name, age, gender, address);
        this.idCus = idCus;
        this.email = email;
        this.wallet = wallet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Customer(String idCus, long wallet) {
        this.idCus = idCus;
        this.wallet = wallet;
    }

    public String getIdCus() {
        return idCus;
    }

    public void setIdCus(String idCus) {
        this.idCus = idCus;
    }

    public long getWallet() {
        return wallet;
    }

    public void setWallet(long wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idCus='" + idCus + '\'' +
                ", email='" + email + '\'' +
                ", wallet=" + wallet +
                '}';
    }
}
