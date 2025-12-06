/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import bussiness.StudentManager;
import dao.IStudentDAO;
import java.util.Collections;

/**
 *
 * @author khoac
 */
public class Menu {

    public static void printMountain() {
        System.out.println("                      ___________");
        System.out.println("                     /           \\");
        System.out.println("                    /             \\");
        System.out.println("                   /               \\");
        System.out.println("                  /                 \\___________");
        System.out.println("                 /                               \\");
        System.out.println("                /         __________              \\");
        System.out.println("               /         /          \\              \\");
        System.out.println("              /         /            \\              \\");
        System.out.println("             /         /              \\              \\");
        System.out.println("            /         /                \\              \\");
        System.out.println("        ___/__       /                  \\              \\");
        System.out.println("       /      \\    /                     \\    __________\\____");
        System.out.println("      /        \\  /                       \\  /               \\");
        System.out.println("     /          \\/                         \\/                 \\");
        System.out.println("    /            \\                         /                   \\");
        System.out.println("   /              \\__________             /                     \\");
        System.out.println("  /                           \\          /                       \\");
        System.out.println(" /                             \\        /                         \\");
        System.out.println("/_______________________________\\______/___________________________\\");
    }

    public static void registerForStudent(IStudentDAO service) {
        StudentManager stuMenu = new StudentManager(service);
        stuMenu.processForRegistration();
    }

    public static void printHeaderForStudent() {
        System.out.println(String.join("", Collections.nCopies(120, "-")));
        String headerFormat = "%-12s | %-20s | %-15s | %-25s | %-15s | %-12s%n";
        System.out.format(headerFormat,
                "Student Id", "Student Name", "Student Phone", "Student Email", "Mountain Code", "Tuition Fee");
        System.out.println(String.join("", Collections.nCopies(120, "-")));
    }

    public static void printRowForStudent(String id, String name, String phone, String email, String mountainCode, double tuitionFee) {
        String rowFormat = "%-12s | %-20s | %-15s | %-25s | %-15s | %-12.0f%n";
        System.out.format(rowFormat, id, name, phone, email, mountainCode, tuitionFee);
        System.out.println(String.join("", Collections.nCopies(120, "-")));
    }
}
