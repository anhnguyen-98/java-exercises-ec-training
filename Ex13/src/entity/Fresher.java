package entity;

import java.time.LocalDate;
import java.util.List;

public class Fresher extends Employee {
    private LocalDate graduationDate;
    private String graduationRank;
    private String education;

    public Fresher(String fullName, LocalDate birthDay, String phone, String email, EmployeeType employeeType,
                   List<Certificate> certificateList, LocalDate graduationDate, String graduationRank, String education) {
        super(fullName, birthDay, phone, email, employeeType, certificateList);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public void showInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Fresher ["
                + getID() + ", "
                + getFullName() + ", "
                + getBirthDay() + ", "
                + getPhone() + ", "
                + getEmail() + ", "
                + getGraduationDate() + ", "
                + getGraduationRank() + ", "
                + getEducation() + "]";
    }
}
