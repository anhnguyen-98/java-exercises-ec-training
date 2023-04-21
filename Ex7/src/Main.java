import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuanLy ql = new QuanLy();

        while (true) {
            System.out.println("Nhap 1 de them Giao Vien");
            System.out.println("Nhap 2 de xem danh sach Giao Vien");
            System.out.println("Nhap 3 de xoa giao vien");
            System.out.println("Nhap 4 de tinh luong thuc cho tat ca Giao Vien");
            System.out.println("Nhap 5 de thoat chuong trinh");
            String line = scanner.nextLine();
            switch (line) {
                case "1": {
                    System.out.print("Nhap ten: ");
                    String name = scanner.nextLine();

                    int age;
                    while (true) {
                        try {
                            System.out.print("Nhap tuoi: ");
                            age = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException ex) {
                            System.out.println("Vui long nhap so!");
                        }
                    }

                    System.out.print("Nhap que quan: ");
                    String queQuan = scanner.nextLine();

                    int luongCung;
                    while (true) {
                        try {
                            System.out.print("Nhap luong cung: ");
                            luongCung = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException ex) {
                            System.out.println("Vui long nhap so!");
                        }
                    }

                    int luongThuong;
                    while (true) {
                        try {
                            System.out.print("Nhap luong thuong: ");
                            luongThuong = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException ex) {
                            System.out.println("Vui long nhap so!");
                        }
                    }

                    int tienPhat;
                    while (true) {
                        try {
                            System.out.print("Nhap tien phat: ");
                            tienPhat = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException ex) {
                            System.out.println("Vui long nhap so!");
                        }
                    }

                    GiaoVien giaoVien = new GiaoVien(name, age, queQuan, luongCung, luongThuong, tienPhat);
                    ql.addGiaoVien(giaoVien);
                    System.out.println(giaoVien);
                    break;
                }
                case "2": {
                    System.out.println(ql.getGiaoVienList());
                    break;
                }
                case "3": {
                    int MSGV = 0;
                    while (true) {
                        try {
                            System.out.print("Nhap ma giao vien: ");
                            MSGV = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException ex) {
                            System.out.println("Vui long nhap so!");
                        }

                        try {
                            ql.deleteGiaoVien(MSGV);
                            break;
                        } catch (EntityNotFoundException ex) {
                            System.out.println("EntityNotFoundException with MSGV = " + MSGV);
                        }
                    }
                    System.out.println("Da xoa Giao Vien ma "+ MSGV);
                    break;
                }
                case "4":
                    System.out.println(ql.countLuongThucForAllGiaoVien());
                    break;
                case "5": return;
                default: {
                    System.out.println("invalid");
                    return;
                }
            }
        }
    }
}