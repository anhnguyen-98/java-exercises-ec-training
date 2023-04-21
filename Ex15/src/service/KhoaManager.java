package service;

import entity.Khoa;
import entity.SinhVien;
import entity.SoLuongSinhVienTheoNamHoc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class KhoaManager {

    private List<Khoa> khoaList;

    public KhoaManager() {
        this.khoaList = new ArrayList<>();
    }

    public void addKhoa(Khoa khoa) {
        khoaList.add(khoa);
    }

    public void showAllKhoa() {
        System.out.println(khoaList);
    }

    public void findALlSinhVienTaiChucMoiKhoaTheoNoiDaoTao(String noiLienKetDaoTao) {
        System.out.println(khoaList.stream()
                .map(khoa -> new Khoa(khoa.getTenKhoa(), khoa.findSinhVienTaiChucByNoiLienKetDaoTao(noiLienKetDaoTao)))
                .collect(Collectors.toList()));
    }

    public void findAllSinhVienByDiemTrungBinhGreiterThan(float diemTrungBinh) {
        System.out.println(khoaList.stream()
                .map(khoa -> new Khoa(khoa.getTenKhoa(), khoa.findSinhVienDiemTrungBinhGreiterThan(diemTrungBinh)))
                .collect(Collectors.toList()));
    }

    public void findSinhVienByDiemTrungBinhHocKyCaoNhat() {
        System.out.println(khoaList.stream()
                .map(khoa -> new Khoa(khoa.getTenKhoa(), List.of(khoa.findSinhVienCoDiemTrungBinhCaoNhat())))
                .collect(Collectors.toList()));
    }

    public void sortSinhVienGiamdanTheoNamHoc() {
        System.out.println(khoaList.stream()
                .map(khoa -> new Khoa(khoa.getTenKhoa(), khoa.sortSinhVienGiamDanTheoNamNhapHoc()))
                .collect(Collectors.toList()));
    }

    public void countSinhVienTheoNamNhapHoc() {
        khoaList.forEach(khoa -> {
            List<Integer> namNhapHocList = khoa.getSinhVienList().stream().map(sinhVien -> sinhVien.getNamNhapHoc())
                    .distinct().collect(Collectors.toList());
            System.out.println("Ten Khoa: " + khoa.getTenKhoa());
            namNhapHocList.forEach(namNhapHoc -> {
                System.out.print("Nam nhap hoc: " + namNhapHoc);
                System.out.println("- So luong sinh vien: " + khoa.countSinhVienByNamNhapHoc(namNhapHoc));
            });
        });
    }
}
