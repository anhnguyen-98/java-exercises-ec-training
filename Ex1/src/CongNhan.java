public class CongNhan extends CanBo {
    private Bac bac;

    public CongNhan(String name, Gender gioiTinh, String diaChi, Bac bac) {
        super(name, gioiTinh, diaChi);
        this.bac = bac;
    }

    public Bac getBac() {
        return bac;
    }

    public void setBac(Bac bac) {
        this.bac = bac;
    }

    @Override
    public String toString() {
        return "CongNhan [" + getName() + ", "
                + getGioiTinh() + ", "
                + getDiaChi() + ", "
                + getBac() + "]";
    }
}
