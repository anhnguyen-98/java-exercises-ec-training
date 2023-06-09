package entity;

public class KetQuaHocTap {
    private int hocKy;
    private float diemTrungBinh;

    public KetQuaHocTap(int hocKy, float diemTrungBinh) {
        this.hocKy = hocKy;
        this.diemTrungBinh = diemTrungBinh;
    }

    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }

    public float getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public void setDiemTrungBinh(float diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }

    @Override
    public String toString() {
        return "Hoc ky: " + getHocKy() + ", "
                + "DTB: " + getDiemTrungBinh();
    }
}
