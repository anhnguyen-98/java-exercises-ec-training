import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class QuanLy {

    private List<HocSinh> hocSinhList;

    QuanLy() {
        hocSinhList = new ArrayList<>();
    }

    public void addHocSinh(HocSinh hocSinh) {
        hocSinhList.add(hocSinh);
    }

    public List<HocSinh> getHocSinhByAge(int age) {
        return hocSinhList.stream().filter(hocSinh -> hocSinh.getAge() == age).collect(Collectors.toList());
    }

    public int countHocSinhByAgeAndQueQuan(int age, String queQuan) {
        return (int) hocSinhList.stream()
                .filter(hocSinh -> hocSinh.getAge() == age && hocSinh.getQueQuan().equals(queQuan)).count();
    }
}
