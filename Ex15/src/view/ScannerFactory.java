package view;

import java.util.Scanner;

public class ScannerFactory {

    private static Scanner SCANNER;

    public static Scanner getScanner() {
        if (SCANNER == null) {
            return new Scanner(System.in);
        }
        return SCANNER;
    }
}
