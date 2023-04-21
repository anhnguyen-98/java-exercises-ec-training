public abstract class CanBo {
    private String name;
    private Gender gioiTinh;
    private String diaChi;

    public CanBo(String name, Gender gioiTinh, String diaChi) {
        this.name = name;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
    }

    public String getName() {
        int x;
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Gender gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
