import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        qlcb.addCanBo(new CongNhan("Tuan Anh", Gender.nam, "Tran Duy Hung", Bac.Bac5));
//        qlcb.addCanBo(new KySu("Truc Anh", Gender.nu, "Le Van Luong", "IT"));
//        qlcb.addCanBo(new NhanVien("Hoai Nam", Gender.nam, "Ho Tung Mau", "Training"));
//
//        System.out.println("Get CanBo by name:");
//        System.out.println(qlcb.findByName("Tuan"));
//
//        System.out.println("Show list can bo:");
//        qlcb.showCanBoList();

        Scanner scanner = new Scanner(System.in);
        QLCB qlcb = new QLCB();
        while (true) {
            System.out.println("Nhap 1 de them Can Bo");
            System.out.println("Nhap 2 de tim Can Bo theo ten");
            System.out.println("Nhap 3 de xem thong tin tat ca Can Bo");
            System.out.println("Nhap 4 de thoat chuong trinh");
            String line = scanner.nextLine();
            switch (line) {
                case "1": {
                    System.out.println("Nhap a de them Cong Nhan");
                    System.out.println("Nhap b de them Ky Su");
                    System.out.println("Nhap c de them Nhan Vien");
                    String type = scanner.nextLine();
                    switch (type) {
                        case "a": {
                            System.out.print("Nhap ten: ");
                            String name = scanner.nextLine();
                            System.out.print("Nhap gioi tinh (nam, nu, khac): ");
                            Gender gioiTinh = Gender.valueOf(scanner.nextLine());
                            System.out.print("Nhap dia chi: ");
                            String diaChi = scanner.nextLine();
                            System.out.print("Nhap bac (bac1, bac2,...bac10): ");
                            Bac bac = Bac.valueOf(scanner.nextLine());
                            CongNhan congNhan = new CongNhan(name, gioiTinh, diaChi, bac);
                            qlcb.addCanBo(congNhan);
                            System.out.println(congNhan);
                            break;
                        }
                        case "b": {
                            System.out.print("Nhap ten: ");
                            String name = scanner.nextLine();
                            System.out.print("Nhap gioi tinh (nam, nu, khac): ");
                            Gender gioiTinh = Gender.valueOf(scanner.nextLine());
                            System.out.print("Nhap dia chi: ");
                            String diaChi = scanner.nextLine();
                            System.out.print("Nhap nganh dao tao: ");
                            String nganhDaoTao = scanner.nextLine();
                            KySu kySu = new KySu(name, gioiTinh, diaChi, nganhDaoTao);
                            qlcb.addCanBo(kySu);
                            System.out.println(kySu);
                            break;
                        }
                        case "c": {
                            System.out.print("Nhap ten: ");
                            String name = scanner.nextLine();
                            System.out.print("Nhap gioi tinh (nam, nu, khac): ");
                            Gender gioiTinh = Gender.valueOf(scanner.nextLine());
                            System.out.print("Nhap dia chi: ");
                            String diaChi = scanner.nextLine();
                            System.out.print("Nhap cong viec: ");
                            String congViec = scanner.nextLine();
                            NhanVien nhanVien = new NhanVien(name, gioiTinh, diaChi, congViec);
                            qlcb.addCanBo(nhanVien);
                            System.out.println(nhanVien);
                            break;
                        }
                    }
                    break;
                }
                case "2": {
                    System.out.println("Nhap ten de tim Can Bo: ");
                    String name = scanner.nextLine();
                    qlcb.findByName(name).forEach(canBo -> System.out.println(canBo));
                    break;
                }
                case "3": {
                    qlcb.showCanBoList();
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