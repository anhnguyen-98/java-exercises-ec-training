import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class QuanLy {

    List<GiaoVien> giaoVienList;

    QuanLy() {
        giaoVienList = new ArrayList<>();
    }

    public void addGiaoVien(GiaoVien giaoVien) {
        giaoVienList.add(giaoVien);
    }


    public GiaoVien findGiaoVienByMSGV(int MSGV) throws EntityNotFoundException {
        Optional<GiaoVien> giaoVienOptional =
                giaoVienList.stream().filter(giaoVien -> giaoVien.getMSGV() == MSGV).findFirst();
        return giaoVienOptional.orElseThrow(() -> {
            throw new EntityNotFoundException();
        });
    }

    public void deleteGiaoVien(int MSGV) {
        GiaoVien giaoVien = findGiaoVienByMSGV(MSGV);
        giaoVienList.remove(giaoVien);
    }

    public List<GiaoVien> getGiaoVienList() {
        return giaoVienList;
    }

    public List<GiaoVien> countLuongThucForAllGiaoVien() {
        return getGiaoVienList().stream().map(giaoVien -> {
            giaoVien.setLuongThuc(giaoVien.tinhLuongThuc());
            return giaoVien;
        }).collect(Collectors.toList());
    }
}
