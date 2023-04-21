package entity;

public class SoLuongSinhVienTheoNamHoc {
    private int namNhapHoc;
    private int soLuong;

    public SoLuongSinhVienTheoNamHoc(int namNhapHoc, int soLuong) {
        this.namNhapHoc = namNhapHoc;
        this.soLuong = soLuong;
    }

    public int getNamNhapHoc() {
        return namNhapHoc;
    }

    public void setNamNhapHoc(int namNhapHoc) {
        this.namNhapHoc = namNhapHoc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "SoLuongSinhVienTheoNamNhapHoc: "
                + "Nam nhap hoc: " + getNamNhapHoc() + ", "
                + "So luong SV: " + getSoLuong();
    }
}
