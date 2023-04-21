package entity;

import java.time.LocalDate;
import java.time.Year;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SinhVien {
    private static int count = 0;
    private int MASV;
    private String hoVaTen;
    private LocalDate ngaySinh;
    private int namNhapHoc;
    private float diemDauVao;
    private List<KetQuaHocTap> ketQuaHocTapList;

    public SinhVien(String hoVaTen, LocalDate ngaySinh, int namNhapHoc, float diemDauVao,
                    List<KetQuaHocTap> ketQuaHocTapList) {
        this.MASV = ++count;
        this.hoVaTen = hoVaTen;
        this.ngaySinh = ngaySinh;
        this.namNhapHoc = namNhapHoc;
        this.diemDauVao = diemDauVao;
        this.ketQuaHocTapList = ketQuaHocTapList;
    }

    public int getMASV() {
        return MASV;
    }

    public void setMASV(int MASV) {
        this.MASV = MASV;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getNamNhapHoc() {
        return namNhapHoc;
    }

    public void setNamNhapHoc(int namNhapHoc) {
        this.namNhapHoc = namNhapHoc;
    }

    public float getDiemDauVao() {
        return diemDauVao;
    }

    public void setDiemDauVao(float diemDauVao) {
        this.diemDauVao = diemDauVao;
    }

    public List<KetQuaHocTap> getKetQuaHocTapList() {
        return ketQuaHocTapList;
    }

    public void setKetQuaHocTapList(List<KetQuaHocTap> ketQuaHocTapList) {
        this.ketQuaHocTapList = ketQuaHocTapList;
    }

    public boolean isSinhVienChinhQuy() {
        return true;
    }

    public float getDiemTrungBinhByHocKy(int hocKy) {
        Optional<KetQuaHocTap> ketQuaHocTapOptional =
                this.ketQuaHocTapList.stream().filter(ketQuaHocTap -> ketQuaHocTap.getHocKy() == hocKy).findFirst();
        return ketQuaHocTapOptional.map(KetQuaHocTap::getDiemTrungBinh).orElse(0.0f);
    }

    public float getDiemTrungBinhKyCuoi() {
        Optional<KetQuaHocTap> ketQuaHocTapOptional =
                this.ketQuaHocTapList.stream().max(Comparator.comparingInt(KetQuaHocTap::getHocKy));
        return ketQuaHocTapOptional.map(KetQuaHocTap::getDiemTrungBinh).orElse(0.0f);
    }

    public float getDiemTrungBinhCaoNhat() {
        Optional<KetQuaHocTap> ketQuaHocTapOptional =
                this.ketQuaHocTapList.stream().max(Comparator.comparingDouble(KetQuaHocTap::getDiemTrungBinh));
        return ketQuaHocTapOptional.map(KetQuaHocTap::getDiemTrungBinh).orElse(0.0f);
    }

    @Override
    public String toString() {
        return "SinhVien: "
                + "MASV: " + getMASV() + ", "
                + "Ho Ten: " + getHoVaTen() + ", "
                + "Ngay sinh: " + getNgaySinh() + ", "
                + "Nam nhap hoc: " + getNamNhapHoc() + ", "
                + "Diem dao vao: " + getDiemDauVao() + ", "
                + "KetQuaHocTap: " + getKetQuaHocTapList() + "\n";
    }
}
