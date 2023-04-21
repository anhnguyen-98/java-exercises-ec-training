import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuanLy ql = new QuanLy();

        while (true) {
            System.out.println("Nhap 1 de them Hoc Sinh");
            System.out.println("Nhap 2 de tim Hoc Sinh 20 tuoi");
            System.out.println("Nhap 3 de dem so Hoc Sinh 23 Tuoi va o DN");
            System.out.println("Nhap 4 de thoat chuong trinh");
            String line = scanner.nextLine();
            switch (line) {
                case "1": {
                    Lop lop;
                    while (true) {
                        try {
                            System.out.print("Nhap lop (lop10, lop11, lop12): ");
                            lop = Lop.valueOf(scanner.nextLine().toUpperCase());
                            break;
                        } catch (IllegalArgumentException ex) {
                            System.out.println("Vui long nhap dung cu phap (lop10, lop11 hoac lop12)!");
                        }
                    }

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
                    HocSinh hocSinh = new HocSinh(lop, name, age, queQuan);
                    ql.addHocSinh(hocSinh);
                    System.out.println(hocSinh);
                    break;
                }
                case "2": {
                    List<HocSinh> hocSinhList = ql.getHocSinhByAge(20);
                    if (!hocSinhList.isEmpty()) {
                        hocSinhList.forEach(System.out::println);
                    } else {
                        System.out.println("Khong co hoc sinh nao 20 tuoi!");
                    }
                    break;
                }
                case "3": {
                    System.out.println(ql.countHocSinhByAgeAndQueQuan(23, "DN"));
                    break;
                }
                case "4": return;
                default: {
                    System.out.println("invalid");
                    return;
                }
            }
        }

    }
}