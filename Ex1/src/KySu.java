public class KySu extends CanBo {
    private String nganhDaoTao;

    public KySu(String name, Gender gioiTinh, String diaChi, String nganhDaoTao) {
        super(name, gioiTinh, diaChi);
        this.nganhDaoTao = nganhDaoTao;
    }

    public String getNganhDaoTao() {
        return nganhDaoTao;
    }

    public void setNganhDaoTao(String nganhDaoTao) {
        this.nganhDaoTao = nganhDaoTao;
    }

    @Override
    public String toString() {
        return "KySu [" + getName() + ", "
                + getGioiTinh() + ", "
                + getDiaChi() + ", "
                + getNganhDaoTao() + "]";
    }
}
