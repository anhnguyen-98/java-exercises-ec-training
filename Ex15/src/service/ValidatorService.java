package service;

import exception.BirthdayException;
import exception.FullNameException;
import exception.NotValidNumberExeption;
import util.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidatorService {

    public static LocalDate checkBirthday(String birthDay) throws BirthdayException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate _birthDay = LocalDate.parse(birthDay, dtf);
        if (_birthDay.isAfter(LocalDate.now())) {
            throw new BirthdayException("Birthday Exception");
        }
        return _birthDay;
    }

    public static LocalDate checkDate(String date) throws DateTimeParseException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(date, dtf);
    }

    public static void checkFullName(String fullName) {
        if (!Utils.containOnlyAlphabet(fullName)) {
            System.out.println("Invalid name!");
            throw new FullNameException();
        }
    }

    public static void checkPositiveNumber(String number) {
        if (!Utils.isPositiveNumber(number)) {
            System.out.println("Invalid number!");
            throw new NotValidNumberExeption();
        }
    }

    public static void checkFloat(String number) {
        if (!Utils.isFloat(number)) {
            System.out.println("Invalid diem trung binh!");
            throw new NotValidNumberExeption();
        }
    }
}
