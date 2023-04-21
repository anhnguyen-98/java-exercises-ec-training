public enum Khoi {

    A("Khoi A","Toan", "Ly", "Hoa"),
    B("Khoi B","Toan", "Hoa", "Sinh"),
    C("Khoi C","Van", "Su", "Dia");
    public final String name;
    public final String mon1;
    public final String mon2;
    public final  String mon3;

    Khoi(String name, String mon1, String mon2, String mon3) {
        this.name = name;
        this.mon1 = mon1;
        this.mon2 = mon2;
        this.mon3 = mon3;
    }
}
