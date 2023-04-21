package util;

public class Utils {
    public static boolean containOnlyAlphabet(String string) {
        return string.matches("^[a-zA-Z ]*$");
    }

    public static boolean containsOnlyNumbers(String string) {
        return string.matches("[0-9]+");
    }

    public static boolean isPositiveNumber(String string) {
        return string.matches("^?\\d+$");
    }

    public static boolean isFloat(String string) {
        return string.matches("^-?\\d+(\\.\\d+)?$");
    }

    public static boolean isValidEmail(String email) {
        return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }
}
