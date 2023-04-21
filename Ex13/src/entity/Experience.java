package entity;

import java.time.LocalDate;
import java.util.List;

public class Experience extends Employee {

    private int expInYear;
    private String proSkill;

    public Experience(String fullName, LocalDate birthDay, String phone, String email,
                      EmployeeType employeeType, List<Certificate> certificateList, int expInYear, String proSkill) {
        super(fullName, birthDay, phone, email, employeeType, certificateList);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public void showInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Experience ["
                + getID() + ", "
                + getFullName() + ", "
                + getBirthDay() + ", "
                + getPhone() + ", "
                + getEmail() + ", "
                + getExpInYear() + ", "
                + getProSkill() + "]";
    }
}
