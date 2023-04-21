public class HocSinh {
    private Lop lop;
    private String name;
    private int age;
    private String queQuan;

    public HocSinh(Lop lop, String name, int age, String queQuan) {
        this.lop = lop;
        this.name = name;
        this.age = age;
        this.queQuan = queQuan;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    @Override
    public String toString() {
        return "HocSinh [" + "Lop: " + getLop().lop + ", "
                + getName() + ", "
                + getAge() + ", "
                + getQueQuan() + "]";
    }
}
