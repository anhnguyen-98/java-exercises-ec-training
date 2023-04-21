package entity;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Khoa {
    private String tenKhoa;
    private List<SinhVien> sinhVienList;

    public Khoa(String tenKhoa, List<SinhVien> sinhVienList) {
        this.tenKhoa = tenKhoa;
        this.sinhVienList = sinhVienList;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public List<SinhVien> getSinhVienList() {
        return sinhVienList;
    }

    public void setSinhVienList(List<SinhVien> sinhVienList) {
        this.sinhVienList = sinhVienList;
    }

    public int countSinhVienChinhQuy() {
        return (int) this.sinhVienList.stream().filter(SinhVien::isSinhVienChinhQuy).count();
    }

    public SinhVien findSinhVienDiemCaoNhat() {
        Optional<SinhVien> sinhVienOptional =
                this.sinhVienList.stream().max(Comparator.comparingDouble(SinhVien::getDiemDauVao));
        return sinhVienOptional.orElse(null);
    }

    public List<SinhVien> findSinhVienTaiChucByNoiLienKetDaoTao(String noiLienKetDaoTao) {
        List<SinhVien> sinhVienTaiChucList =
                this.sinhVienList.stream().filter(sinhVien -> !sinhVien.isSinhVienChinhQuy()).collect(Collectors.toList());
        List<SinhVienTaiChuc> sinhVienTaiChucList1 =
                sinhVienTaiChucList.stream().map(sinhVien -> (SinhVienTaiChuc) sinhVien).collect(Collectors.toList());
        return sinhVienTaiChucList1.stream()
                .filter(sinhVienTaiChuc -> sinhVienTaiChuc.getNoiLienKetDaoTao().equals(noiLienKetDaoTao))
                .collect(Collectors.toList());
    }

    public List<SinhVien> findSinhVienDiemTrungBinhGreiterThan(float diemTrungBinh) {
        return this.sinhVienList.stream().filter(sinhVien -> sinhVien.getDiemTrungBinhKyCuoi() >= diemTrungBinh)
                .collect(Collectors.toList());
    }

    public SinhVien findSinhVienCoDiemTrungBinhCaoNhat() {
        return this.sinhVienList.stream().max(Comparator.comparing(SinhVien::getDiemTrungBinhCaoNhat)).orElse(null);
    }

    public List<SinhVien> sortSinhVienGiamDanTheoNamNhapHoc() {
        return this.sinhVienList.stream().sorted((o1, o2) -> Integer.compare(o2.getNamNhapHoc(), o1.getNamNhapHoc()))
                .collect(Collectors.toList());
    }

    public int countSinhVienByNamNhapHoc(int namNhapHoc) {
        return (int) this.sinhVienList.stream().filter(sinhVien -> sinhVien.getNamNhapHoc() == namNhapHoc).count();
    }

    @Override
    public String toString() {
        return "Ten Khoa: " + getTenKhoa() + "\n"
                + "Danh sach sinh vien: \n"
                + getSinhVienList();
    }
}
