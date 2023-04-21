package view;

import entity.KetQuaHocTap;
import entity.Khoa;
import entity.SinhVien;
import entity.SinhVienTaiChuc;
import exception.BirthdayException;
import exception.FullNameException;
import exception.NotValidNumberExeption;
import service.KhoaManager;
import service.ValidatorService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UIManager {

    private Scanner scanner = ScannerFactory.getScanner();

    private KhoaManager khoaManager = new KhoaManager();

    public void overallView() {
        while (true) {
            System.out.println("Enter 1 to them 1 Khoa moi");
            System.out.println("Enter 2 to find all SinhVienTaiChuc theo NoiLienKetDaoTao o moi Khoa");
            System.out.println("Enter 3 to tim danh sach cac Sinh Vien co diem trung binh hoc ky gan nhat >= 8.0 o moi Khoa");
            System.out.println("Enter 4 to tim SinhVien co diem trung binh hoc ky cao nhat");
            System.out.println("Enter 5 to sap xep SinhVien giam dan theo nam nhap hoc o moi Khoa");
            System.out.println("Enter 6 to thong ke so sinh vien theo nam nhap hoc o moi Khoa");
            System.out.println("Enter 7 to xem thong tin tat ca Khoa");
            System.out.println("Enter 8 to exit");
            String line = scanner.nextLine();
            switch (line) {
                case "1": {addKhoaView(); break;}
                case "2": {findAllSinhVienTaiChucTheoNoiLienKetDaoTaoView(); break;}
                case "3": {findSinhVienByDiemTrungBinhHocKyGreiterEqualThan8View(); break;}
                case "4": {findSinhVienByDiemTrungBinhHocKyCaoNhatView(); break;}
                case "5": {sortSinhVienGiamdanTheoNamHocView(); break;}
                case "6": {thongKeSinhVienTheoNamNhapHocView(); break;}
                case "7": {khoaManager.showAllKhoa(); break;}
                case "8": return;
                default: {
                    System.out.println("Invalid!");
                    return;
                }
            }
        }
    }

    private void thongKeSinhVienTheoNamNhapHocView() {
        khoaManager.countSinhVienTheoNamNhapHoc();
    }

    private void sortSinhVienGiamdanTheoNamHocView() {
        khoaManager.sortSinhVienGiamdanTheoNamHoc();
    }

    private void findSinhVienByDiemTrungBinhHocKyCaoNhatView() {
        khoaManager.findSinhVienByDiemTrungBinhHocKyCaoNhat();
    }

    private void findSinhVienByDiemTrungBinhHocKyGreiterEqualThan8View() {
        khoaManager.findAllSinhVienByDiemTrungBinhGreiterThan(8);
    }

    private void addKhoaView() {
        System.out.println("Enter ten khoa: ");
        String tenKhoa = scanner.nextLine();
        List<SinhVien> sinhVienList = addSinhVienView();
        khoaManager.addKhoa(new Khoa(tenKhoa, sinhVienList));
    }

    private void findAllSinhVienTaiChucTheoNoiLienKetDaoTaoView() {
        System.out.println("Enter noi lien ket dao dao: ");
        String noiLienKetDaoTao = scanner.nextLine();
        khoaManager.findALlSinhVienTaiChucMoiKhoaTheoNoiDaoTao(noiLienKetDaoTao);
    }

    private List<SinhVien> addSinhVienView() {
        List<SinhVien> sinhVienList = new ArrayList<>();
        while (true) {
            System.out.println("Enter a to insert SinhVienChinhQuy");
            System.out.println("Enter b to insert SinhVienTaiChuc");
            String type = scanner.nextLine();
            switch (type) {
                case "a": {
                    sinhVienList.add(addSinhVien(false));
                    break;
                }
                case "b": {
                    sinhVienList.add(addSinhVien(true));
                    break;
                }
                default: {
                    System.out.println("Invalid");
                }
            }

            System.out.println("Do you want to end adding SinhVien?");
            System.out.println("0 to end, 1 (or other numbers) to continue");
            String endValue = scanner.nextLine();
            if (endValue.equals("0")) break;
        }
        return sinhVienList;
    }

    private SinhVien addSinhVien(boolean isSinhVienTaiChuc) {
        String hoVaTen;
            while (true) {
            try {
                System.out.println("Enter ho va ten: ");
                hoVaTen = scanner.nextLine();
                ValidatorService.checkFullName(hoVaTen);
                break;
            } catch (FullNameException ex) {
                throw new FullNameException();
            }
        }

        LocalDate ngaySinh;
            while (true) {
            try {
                System.out.print("Enter ngay sinh [dd.MM.yyyy]: ");
                String _birthDay = scanner.nextLine();
                ngaySinh = ValidatorService.checkBirthday(_birthDay);
                break;
            } catch (DateTimeParseException ex) {
                System.out.println("Invalid date input!");
            }
            catch (BirthdayException ex) {
                System.out.println(ex);
            }
        }

        int namNhapHoc;
        String namNhapHocString;
            while (true) {
            try {
                System.out.print("Enter nam nhap hoc: ");
                namNhapHocString = scanner.nextLine();
                ValidatorService.checkPositiveNumber(namNhapHocString);
                namNhapHoc = Integer.parseInt(namNhapHocString);
                break;
            } catch(NotValidNumberExeption ex) {
                System.out.println(ex);
            }
        }

        float diemDaoVao;
        String diemDaoVaoString;
        while (true) {
            try {
                System.out.print("Enter diem dao vao: ");
                diemDaoVaoString = scanner.nextLine();
                ValidatorService.checkFloat(diemDaoVaoString);
                diemDaoVao = Float.parseFloat(diemDaoVaoString);
                break;
            } catch(NotValidNumberExeption ex) {
                System.out.println(ex);
            }
        }

        List<KetQuaHocTap> ketQuaHocTapList = addKetQuaHocTapView();

        String noiLienKetDaoTao;
        if (isSinhVienTaiChuc) {
            System.out.println("Enter noi lien ket dao tao: ");
            noiLienKetDaoTao = scanner.nextLine();
            return new SinhVienTaiChuc(hoVaTen, ngaySinh, namNhapHoc, diemDaoVao, ketQuaHocTapList, noiLienKetDaoTao);
        }

        return new SinhVien(hoVaTen, ngaySinh, namNhapHoc, diemDaoVao, ketQuaHocTapList);
    }

    private List<KetQuaHocTap> addKetQuaHocTapView() {
        System.out.println("Add Ket qua hoc tap");
        List<KetQuaHocTap> ketQuaHocTapList = new ArrayList<>();

        while (true) {
            int hocKy = 0;
            String hocKyString = "0";
            while (true) {
                try {
                    System.out.println("Enter hoc ky: ");
                    hocKyString = scanner.nextLine();
                    ValidatorService.checkPositiveNumber(hocKyString);
                    hocKy = Integer.parseInt(hocKyString);
                    break;
                } catch (NotValidNumberExeption ex) {
                    System.out.println(ex);
                }
            }

            float diemTrungBinh = 0;
            String diemTrungBinhString = "0";
            while (true) {
                try {
                    System.out.println("Enter diem trung binh: ");
                    diemTrungBinhString = scanner.nextLine();
                    ValidatorService.checkFloat(hocKyString);
                    diemTrungBinh = Float.parseFloat(diemTrungBinhString);
                    break;
                } catch (NotValidNumberExeption ex) {
                    System.out.println(ex);
                }
            }

            ketQuaHocTapList.add(new KetQuaHocTap(hocKy, diemTrungBinh));
            System.out.println("Do you want to end adding KetQuaHocTap?");
            System.out.println("0 to end, 1 (or other numbers) to continue");
            String endValue = scanner.nextLine();
            if (endValue.equals("0")) break;
        }
        return ketQuaHocTapList;
    }
}
