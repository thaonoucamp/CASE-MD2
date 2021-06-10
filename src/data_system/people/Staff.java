package data_system.people;

public class Staff extends Person {
    private static Staff INSTANCE = new Staff();

    @Override
    public String toString() {
        return "Staff{" + super.toString() +
                ", idStaff='" + idStaff + '\'' +
                ", kip='" + kip + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", bonus=" + bonus +
                ", rice=" + rice +
                '}';
    }

    public Staff(String idStaff, String name, String age, String gender, String address, String kip, String telephone, String email, long bonus, long rice) {
        super(name, age, gender, address);
        this.idStaff = idStaff;
        this.kip = kip;
        this.telephone = telephone;
        this.email = email;
        this.bonus = bonus;
        this.rice = rice;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static Staff getStaff() {
        return INSTANCE;
    }

    private String idStaff;

    public String getKip() {
        return kip;
    }

    public void setKip(String kip) {
        this.kip = kip;
    }

    private String kip;
    private String telephone;
    private String email;
    private long bonus;
    private long rice;

    private Staff() {
    }

    public Staff(String name, String age, String gender, String address) {
        super(name, age, gender, address);
    }

    public String getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(String idStaff) {
        this.idStaff = idStaff;
    }

    public long getBonus() {
        return bonus;
    }

    public void setBonus(long bonus) {
        this.bonus = bonus;
    }

    public long getRice() {
        return rice;
    }

    public void setRice(long rice) {
        this.rice = rice;
    }

}