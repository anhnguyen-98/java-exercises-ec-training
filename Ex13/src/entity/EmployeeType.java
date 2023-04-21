package entity;

import java.util.Arrays;
import java.util.Map;

public enum EmployeeType {
    EXPERIENCE(0), FRESHER(1), INTERN(2);

    private int type;

    EmployeeType(int type) {
        this.type = type;
    }

    public int getValue() {
        return type;
    }

    public static EmployeeType getByValue(int type){
        return Arrays.stream(EmployeeType.values())
                .filter(employeeType -> employeeType.type == type).findFirst().orElse(EXPERIENCE);
    }
}
