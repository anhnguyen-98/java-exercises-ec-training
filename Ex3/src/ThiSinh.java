public class ThiSinh {
    private static int count = 0;
    private int soBaoDanh;
    private String name;
    private String diaChi;
    private Khoi khoi;

    public ThiSinh(String name, String diaChi, Khoi khoi) {
        this.soBaoDanh = ++count;
        this.name = name;
        this.diaChi = diaChi;
        this.khoi = khoi;
    }

    public int getSoBaoDanh() {
        return soBaoDanh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Khoi getKhoi() {
        return khoi;
    }

    public void setKhoi(Khoi khoi) {
        this.khoi = khoi;
    }

    @Override
    public String toString() {
        return "ThiSinh [" + getSoBaoDanh() + ", "
                + getName() + ", "
                + getDiaChi() + ", "
                + getKhoi().name + ": " + getKhoi().mon1 + ", " + getKhoi().mon2 + ", " + getKhoi().mon3 +
                "]";
    }
}
