package view;

import entity.*;
import exception.*;
import service.EmployeeManager;
import service.ValidatorService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UIManager {

    private Scanner scanner = ScannerFactory.getScanner();

    private EmployeeManager employeeManager = new EmployeeManager();

    public void viewOverall() {
        while (true) {
            System.out.println("Enter 1 to insert a new Employee");
            System.out.println("Enter 2 to modify an Employee");
            System.out.println("Enter 3 to find all employees");
            System.out.println("Enter 4 to find all experienced employees");
            System.out.println("Enter 5 to find all Freshers");
            System.out.println("Enter 6 to find all Interns");
            System.out.println("Enter 7 to exit");
            String line = scanner.nextLine();
            switch (line) {
                case "1": {addEmployeeView(); break;}
                case "2": {editEmployeeView(); break;}
                case "3": {employeeManager.showAllEmployyees(); break;}
                case "4": {findAllExperiencesView(); break;}
                case "5": {findAllFreshersView(); break;}
                case "6": {findAllInternsView(); break;}
                case "7": return;
                default: {
                    System.out.println("Invalid!");
                    return;
                }
            }
        }
    }

    public void addEmployeeView() {
        System.out.println("Enter a to insert Experience");
        System.out.println("Enter b to insert Fresher");
        System.out.println("Enter c to insert Intern");
        String type = scanner.nextLine();
        switch (type) {
            case "a": {
                addEmployeeByEmployeeTypeView(EmployeeType.EXPERIENCE);
                break;
            }
            case "b": {
                addEmployeeByEmployeeTypeView(EmployeeType.FRESHER);
                break;
            }
            case "c": {
                addEmployeeByEmployeeTypeView(EmployeeType.INTERN);
                break;
            }
            default: {
                System.out.println("Invalid");
            }
        }
    }

    public Employee collectEmployeeInfoByEmployeeType(EmployeeType employeeType) {

        String fullName;
        while (true) {
            try {
                System.out.println("Enter full name: ");
                fullName = scanner.nextLine();
                ValidatorService.checkFullName(fullName);
                break;
            } catch (FullNameException ex) {
                System.out.println(ex);
            }
        }

        LocalDate birthDay;
        while (true) {
            try {
                System.out.print("Enter birthday [dd.MM.yyyy]: ");
                String _birthDay = scanner.nextLine();
                birthDay = ValidatorService.checkBirthday(_birthDay);
                break;
            } catch (DateTimeParseException ex) {
                System.out.println("Invalid date input!");
            } catch (BirthdayException ex) {
                System.out.println(ex);
            }
        }

        String phone;
        while (true) {
            try {
                System.out.print("Enter phone: ");
                phone = scanner.nextLine();
                ValidatorService.checkPhone(phone);
                break;
            } catch(PhoneException ex) {
                System.out.println(ex);
            }
        }

        String email;
        while (true) {
            try {
                System.out.println("Enter email: ");
                email = scanner.nextLine();
                ValidatorService.checkEmail(email);
                break;
            } catch (EmailException ex) {
                System.out.println(ex);
            }
        }

        List<Certificate> certificateList = addCertificates();
        Employee newEmployee;

        if (employeeType == EmployeeType.EXPERIENCE) {
            int expInYear = 0;
            String expInYearString = "0";
            while (true) {
                try {
                    System.out.println("Enter experience in year: ");
                    expInYearString = scanner.nextLine();
                    ValidatorService.checkPositiveNumber(expInYearString);
                    expInYear = Integer.parseInt(expInYearString);
                    break;
                } catch (NotValidNumberExeption ex) {
                    System.out.println(ex);
                }
            }

            System.out.println("Enter professional skill: ");
            String proSkill = scanner.nextLine();
            newEmployee = new Experience(fullName, birthDay, phone, email, employeeType, certificateList,
                    expInYear, proSkill);

        } else if (employeeType == EmployeeType.FRESHER) {
            LocalDate graduationDate;
            while (true) {
                try {
                    System.out.println("Enter graduation date [dd.MM.yyyy]: ");
                    String _graduationDate = scanner.nextLine();
                    graduationDate = ValidatorService.checkDate(_graduationDate);
                    break;
                } catch (DateTimeParseException ex) {
                    System.out.println("Invalid date input!");
                }
            }
            System.out.println("Enter graduation rank: ");
            String graduationRank = scanner.nextLine();
            System.out.println("Enter education: ");
            String education = scanner.nextLine();
            newEmployee = new Fresher(fullName, birthDay, phone, email, employeeType, certificateList,
                    graduationDate, graduationRank, education);

        } else {
            System.out.println("Enter major: ");
            String major = scanner.nextLine();
            int semester = 0;
            String semesterString = "0";
            while (true) {
                try {
                    System.out.println("Enter semester: ");
                    semesterString = scanner.nextLine();
                    ValidatorService.checkPositiveNumber(semesterString);
                    semester = Integer.parseInt(semesterString);
                    break;
                } catch (NotValidNumberExeption ex) {
                    System.out.println(ex);
                }
            }

            System.out.println("Enter university name: ");
            String universityName = scanner.nextLine();
            newEmployee = new Intern(fullName, birthDay, phone, email, employeeType, certificateList,
                    major, semester, universityName);
        }
        return newEmployee;
    }

    public void addEmployeeByEmployeeTypeView(EmployeeType employeeType) {
        employeeManager.addEmployee(collectEmployeeInfoByEmployeeType(employeeType));
        employeeManager.showAllEmployyees();
    }

    public void editEmployeeView() {
        System.out.println("Enter a to edit Employee");
        System.out.println("Enter b to remove Employee");
        String line = scanner.nextLine();
        switch (line) {
            case "a": {
                while (true) {
                    try {
                        System.out.println("Enter Employee ID to edit");
                        String _ID = scanner.nextLine();
                        ValidatorService.checkID(_ID);
                        int ID = Integer.parseInt(_ID);
                        Employee existingEmployee = employeeManager.findEmployeeByID(ID);
                        Employee updatedEmployee = collectEmployeeInfoByEmployeeType(existingEmployee.getEmployeeType());
                        employeeManager.editEmployee(ID, updatedEmployee);
                        break;
                    } catch (EmployeeNotFoundException ex) {
                        System.out.println(ex.getMessage());
                    } catch (IDException ex) {
                        System.out.println(ex);
                    }
                }
                break;

            }
            case "b": {
                while (true) {
                    try {
                        System.out.println("Enter Employee ID to remove");
                        String _ID = scanner.nextLine();
                        ValidatorService.checkID(_ID);
                        int ID = Integer.parseInt(_ID);
                        employeeManager.removeEmployee(ID);
                        break;
                    } catch (EmployeeNotFoundException ex) {
                        System.out.println(ex.getMessage());
                    } catch (IDException ex) {
                        System.out.println(ex);
                    }
                }
                break;
            }
            default: {
                System.out.println("invalid!");
            }
        }
    }
    private void findAllExperiencesView() {
        System.out.println(employeeManager.findAllEmployeeByEmployeeType(EmployeeType.EXPERIENCE));
    }

    private void findAllFreshersView() {
        System.out.println(employeeManager.findAllEmployeeByEmployeeType(EmployeeType.FRESHER));
    }

    private void findAllInternsView() {
        System.out.println(employeeManager.findAllEmployeeByEmployeeType(EmployeeType.INTERN));
    }
    public List<Certificate> addCertificates() {
        List<Certificate> certificateList = new ArrayList<>();
        System.out.println("Add certificates");
        System.out.println("Enter 0 if you don't want to add any certificates, enter 1 to add certificates");
        String line = scanner.nextLine();
        if (line.equals("0")) return certificateList;
        while (true) {
            System.out.println("Type certificate name: ");
            String certificateName = scanner.nextLine();
            System.out.println("Type certificate rank: ");
            String certificateRank = scanner.nextLine();

            LocalDate certificateDate;
            while (true) {
                try {
                    System.out.println("Type certificate date: ");
                    String _certificateDate = scanner.nextLine();
                    certificateDate = ValidatorService.checkDate(_certificateDate);
                    break;
                } catch (DateTimeParseException ex) {
                    System.out.println("Invalid date input!");
                }
            }
            certificateList.add(new Certificate(certificateName, certificateRank, certificateDate));
            System.out.println("Do you want to end adding certificates?");
            System.out.println("0 to end, 1 (or other numbers) to continue");
            String endValue = scanner.nextLine();
            if (endValue.equals("0")) break;

        }
        return certificateList;
    }
}
