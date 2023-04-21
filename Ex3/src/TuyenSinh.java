import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TuyenSinh {

    private List<ThiSinh> thiSinhList;

    TuyenSinh() {
        thiSinhList = new ArrayList<>();
    }

    public void addThiSinh(ThiSinh thiSinh) {
        thiSinhList.add(thiSinh);
    }

    public ThiSinh findBySBD(int soBaoDanh) {
        Optional<ThiSinh> thiSinhBySBD = thiSinhList.stream()
                .filter(thiSinh -> thiSinh.getSoBaoDanh() == soBaoDanh).findFirst();
        try {
            return thiSinhBySBD.orElseThrow(() -> {
                throw new EntityNotFoundException("This Thi Sinh doesn't exist!");
            });
        } catch (EntityNotFoundException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public void showThiSinhList() {
        System.out.println(thiSinhList);
    }
}
