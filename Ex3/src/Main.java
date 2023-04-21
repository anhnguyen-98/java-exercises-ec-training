import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TuyenSinh tuyenSinh = new TuyenSinh();
        while (true) {
            System.out.println("Nhap 1 de them Thi Sinh");
            System.out.println("Nhap 2 de xem thong tin cac Thi Sinh");
            System.out.println("Nhap 3 de tim Thi Sinh bang ID");
            System.out.println("Nhap 4 de thoat chuong trinh");
            String line = scanner.nextLine();
            switch (line) {
                case "1": {
                    System.out.print("Nhap ten: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhap dia chi: ");
                    String diaChi = scanner.nextLine();
                    System.out.print("Nhap khoi (a, b, c): ");
                    Khoi khoi = Khoi.valueOf(scanner.nextLine().toUpperCase());
                    ThiSinh thiSinh = new ThiSinh(name, diaChi, khoi);
                    tuyenSinh.addThiSinh(thiSinh);
                    System.out.println(thiSinh);
                    break;
                }
                case "2": {
                    tuyenSinh.showThiSinhList();
                    break;
                }
                case "3": {
                    while (true) {
                        try {
                            System.out.println("Nhap SBD de tim Thi Sinh: ");
                            int SBD = Integer.parseInt(scanner.nextLine());
                            System.out.println(tuyenSinh.findBySBD(SBD));
                            break;
                        } catch (NumberFormatException ex) {
                            System.out.println("Vui long nhap so!");
                        }
                    }
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