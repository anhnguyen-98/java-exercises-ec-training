package entity;

import java.time.LocalDate;
import java.util.List;

public abstract class Employee {

    private static int count = 0;
    private int ID;
    private String fullName;
    private LocalDate birthDay;
    private String phone;
    private String email;
    private EmployeeType employeeType;
    private List<Certificate> certificateList;

    public Employee(String fullName, LocalDate birthDay, String phone, String email, EmployeeType employeeType,
                    List<Certificate> certificateList) {
        this.ID = ++count;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.employeeType = employeeType;
        this.certificateList = certificateList;
    }

    public int getID() {
        return ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public List<Certificate> getCertificateList() {
        return certificateList;
    }

    public void setCertificateList(List<Certificate> certificateList) {
        this.certificateList = certificateList;
    }

    public abstract void showInfo();
}
