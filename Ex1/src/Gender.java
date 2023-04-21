public enum Gender {
    nam(1), nu(2), khac(3);

    private int value;

    Gender(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
