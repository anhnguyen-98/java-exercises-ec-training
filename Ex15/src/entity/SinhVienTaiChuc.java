package entity;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;

public class SinhVienTaiChuc extends SinhVien {
    private String noiLienKetDaoTao;

    public SinhVienTaiChuc(String hoVaTen, LocalDate ngaySinh, int namNhapHoc, float diemDauVao,
                           List<KetQuaHocTap> ketQuaHocTapList, String noiLienKetDaoTao) {
        super(hoVaTen, ngaySinh, namNhapHoc, diemDauVao, ketQuaHocTapList);
        this.noiLienKetDaoTao = noiLienKetDaoTao;
    }

    public String getNoiLienKetDaoTao() {
        return noiLienKetDaoTao;
    }

    public void setNoiLienKetDaoTao(String noiLienKetDaoTao) {
        this.noiLienKetDaoTao = noiLienKetDaoTao;
    }

    @Override
    public boolean isSinhVienChinhQuy() {
        return false;
    }

    @Override
    public String toString() {
        return "SinhVienTaiChuc: "
                + "MASV: " + getMASV() + ", "
                + "Ho Ten: " + getHoVaTen() + ", "
                + "Ngay sinh: " + getNgaySinh() + ", "
                + "Nam nhap hoc: " + getNamNhapHoc() + ", "
                + "Diem dao vao: " + getDiemDauVao() + ", "
                + "KetQuaHocTap: " + getKetQuaHocTapList() + ", "
                + "LKDT: " + getNoiLienKetDaoTao() + "\n";
    }
}
