package creat;

public class Staff extends Person{
    private String idStaff;
    private long bonus;
    private long rice;

    public Staff(String idStaff, long bonus, long rice) {
        this.idStaff = idStaff;
        this.bonus = bonus;
        this.rice = rice;
    }

    public Staff() {
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

    @Override
    public String toString() {
        return "Staff{" + super.toString() +
                " idStaff='" + idStaff + '\'' +
                ", bonus=" + bonus +
                ", rice=" + rice +
                '}';
    }
}
