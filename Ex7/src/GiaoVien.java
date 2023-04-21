public class GiaoVien {
    private static int count = 0;
    private int MSGV;
    private String name;
    private int age;
    private String queQuan;
    private int luongCung;
    private int luongThuong;
    private int tienPhat;
    private int luongThuc = 0;

    public GiaoVien(String name, int age, String queQuan, int luongCung, int luongThuong, int tienPhat) {
        this.MSGV = ++count;
        this.name = name;
        this.age = age;
        this.queQuan = queQuan;
        this.luongCung = luongCung;
        this.luongThuong = luongThuong;
        this.tienPhat = tienPhat;
    }

    public int tinhLuongThuc() {
        return luongCung + luongThuong - tienPhat;
    }

    public int getMSGV() {
        return MSGV;
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

    public int getLuongCung() {
        return luongCung;
    }

    public void setLuongCung(int luongCung) {
        this.luongCung = luongCung;
    }

    public int getLuongThuong() {
        return luongThuong;
    }

    public void setLuongThuong(int luongThuong) {
        this.luongThuong = luongThuong;
    }

    public int getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(int tienPhat) {
        this.tienPhat = tienPhat;
    }

    public int getLuongThuc() {
        return luongThuc;
    }

    public void setLuongThuc(int luongThuc) {
        this.luongThuc = luongThuc;
    }

    @Override
    public String toString() {
        return "GiaoVien [" + getMSGV() + ", "
                + "Ten: " + getName() + ", "
                + "Tuoi: " + getAge() + ", "
                + "Que: " + getQueQuan() + ", "
                + "LC: " + getLuongCung() + ", "
                + "LThuong: " + getLuongThuong() + ", "
                + "TP: " + getTienPhat() + ", "
                + "LThuc: " + getLuongThuc() + "]";
    }
}
