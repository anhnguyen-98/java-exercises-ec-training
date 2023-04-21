package entity;

import java.time.LocalDate;
import java.util.List;

public class Intern extends Employee {
    private String major;
    private int semester;
    private String universityName;

    public Intern(String fullName, LocalDate birthDay, String phone, String email, EmployeeType employeeType,
                  List<Certificate> certificateList, String major, int semester, String universityName) {
        super(fullName, birthDay, phone, email, employeeType, certificateList);
        this.major = major;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public void showInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Intern ["
                + getID() + ", "
                + getFullName() + ", "
                + getBirthDay() + ", "
                + getPhone() + ", "
                + getEmail() + ", "
                + getMajor() + ", "
                + getSemester() + ", "
                + getUniversityName() + "]";
    }
}
