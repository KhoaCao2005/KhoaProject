/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author khoac
 */
public class Inputter {

    private static final Scanner NDL = new Scanner(System.in);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static LocalDate inputLocalDate(String prompt) {
        LocalDate date = null;
        while (date == null) {
            System.out.print(prompt);
            String input = NDL.nextLine();
            try {
                date = LocalDate.parse(input, FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("Error format! Please enter again!");
            }
        }
        return date;
    }

    public static String getString(String mess) {
        String s;
        System.out.println(mess);
        s = getString();
        return s;
    }

    public static String getString() {
        String s = NDL.nextLine();
        return s;
    }

    public static int getInt(String mess) {
        int num = 0;
        System.out.println(mess);
        num = getInt();
        return num;
    }

    public static int getInt() {
        int num = 0;
        String s = NDL.nextLine();
        num = Integer.parseInt(s);
        return num;
    }

    public static String inputAndLoop(String mess, String pattern) {
        String result = "";
        boolean more = true;
        do {
            result = getString(mess);
            more = !Acceptable.isValid(result, pattern);
            if (more) {
                System.out.println("Data is invalid!");
            }
        } while (more);
        return result;
    }
}
