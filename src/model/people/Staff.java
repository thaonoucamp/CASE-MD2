package model.people;

public class Staff extends Person {
    private static Staff INSTANCE = new Staff();
    private final long RICE_BASE = 3000000;

    public long getRICE_BASE() {
        return RICE_BASE;
    }

    @Override
    public String toString() {
        return "Staff{" + super.toString() +
                ", idStaff='" + idStaff + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", bonus=" + bonus +
                ", rice=" + rice +
                '}';
    }

    public Staff(String idStaff, String name, String age, String gender, String address, String telephone, String email, long bonus, long rice) {
        super(name, age, gender, address);
        this.idStaff = idStaff;
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

    private String telephone;
    private String email;
    private long bonus;
    private long rice;

    private Staff() {
        this.rice = RICE_BASE;
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
