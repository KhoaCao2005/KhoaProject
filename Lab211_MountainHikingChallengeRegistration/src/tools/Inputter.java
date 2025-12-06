/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Scanner;

/**
 *
 * @author khoac
 */
public class Inputter {

    private static final Scanner NDL = new Scanner(System.in);

    public static int getInt(String mess) {
        int num = 0;
        System.out.println(mess);
        num = getInt();
        return num;
    }

    public static int getInt() {
        int num = 0;
        String s = NDL.nextLine();
        if (!Acceptable.isValid(s, Acceptable.INTEGER_VALID)) {
            System.out.println("Please enter an integer number!");
        } else {
            num = Integer.parseInt(s);
        }
        return num;
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
