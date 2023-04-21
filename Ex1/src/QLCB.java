import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QLCB {

    private List<CanBo> canBoList;

    QLCB() {
        canBoList = new ArrayList<>();
    }

    public void addCanBo(CanBo canBo) {
        canBoList.add(canBo);
    }

    public List<CanBo> findByName(String name) {
        return canBoList.stream().filter(canBo -> canBo.getName().equals(name))
                        .collect(Collectors.toList());
    }

    public void showCanBoList() {
        System.out.println(canBoList);
    }
}
