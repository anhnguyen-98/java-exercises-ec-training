package service;

import entity.*;
import exception.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeManager {
    private List<Employee> employeeList = new ArrayList<>();

    public Employee addEmployee(Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    public Employee findEmployeeByID(int ID) {
        Optional<Employee> employeeOptional = employeeList.stream()
                .filter(employee -> employee.getID() == ID).findFirst();
        return employeeOptional.orElseThrow(() -> {
            throw new EmployeeNotFoundException("Cannot find Employee by ID " + ID);
        });
    }

    public Employee editEmployee(int ID, Employee updatedEmployee) {
        Employee emp = findEmployeeByID(ID);
        emp.setFullName(updatedEmployee.getFullName());
        emp.setBirthDay(updatedEmployee.getBirthDay());
        emp.setPhone(updatedEmployee.getPhone());
        emp.setEmail(updatedEmployee.getEmail());
        emp.setEmployeeType(updatedEmployee.getEmployeeType());
        emp.setCertificateList(updatedEmployee.getCertificateList());
        if (emp.getEmployeeType() == EmployeeType.EXPERIENCE) {
            Experience exp = (Experience) emp;
            exp.setExpInYear(((Experience) updatedEmployee).getExpInYear());
            exp.setProSkill(((Experience) updatedEmployee).getProSkill());
        } else if (emp.getEmployeeType() == EmployeeType.FRESHER) {
            Fresher fr = (Fresher) emp;
            fr.setGraduationDate(((Fresher) updatedEmployee).getGraduationDate());
            fr.setGraduationRank(((Fresher) updatedEmployee).getGraduationRank());
            fr.setEducation(((Fresher) updatedEmployee).getEducation());
        } else {
            Intern intern = (Intern) emp;
            intern.setMajor(((Intern) updatedEmployee).getMajor());
            intern.setSemester(((Intern) updatedEmployee).getSemester());
            intern.setUniversityName(((Intern) updatedEmployee).getUniversityName());
        }
        System.out.println("Update successfully!");
        return updatedEmployee;
    }

    public void removeEmployee(int ID) {
        Optional<Employee> employeeOptional = employeeList.stream()
                .filter(employee -> employee.getID() == ID).findFirst();
        employeeOptional.ifPresentOrElse(employee -> {
                employeeList.remove(employee);
                System.out.println("Successfully remove!");
            },
            () -> {
                throw new EmployeeNotFoundException("Cannot find Employee by ID "+ ID);
        });

    }

    public List<Employee> findAllEmployeeByEmployeeType(EmployeeType employeeType) {
        return employeeList.stream()
                .filter(employee -> employee.getEmployeeType() == employeeType).collect(Collectors.toList());
    }

    public void showAllEmployyees() {
        System.out.println(employeeList);
    }
}
