/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatcher;

import bussiness.MountainManager;
import dao.IStudentDAO;
import dao.StudentDAO;
import java.util.Collections;
import tools.Inputter;
import tools.Menu;

/**
 *
 * @author khoac
 */
public class Main {

    public static void main(String[] args) {
        int choice;
        try {
            do {
                Menu.printMountain();
                System.out.println("");
                System.out.println(String.join("", Collections.nCopies(27, "-")));
                System.out.println("|MOUNTAIN HIKING!         |");
                System.out.println(String.join("", Collections.nCopies(27, "-")));
                System.out.println("|1. REGISTER FOR STUDENT. |");
                System.out.println("|2. SEE THE MOUNTAIN LIST.|");
                System.out.println("|3. >>QUIT PROGRAM<<      |");
                System.out.println(String.join("", Collections.nCopies(27, "-")));              
                System.out.println("Please choose: ");
                choice = Inputter.getInt();
                switch (choice) {
                    case 1:
                        IStudentDAO studentService = new StudentDAO();
                        Menu.registerForStudent(studentService);
                        break;
                    case 2:
                        MountainManager mountainManager = new MountainManager();
                        mountainManager.printAllMountains();
                        break;
                    default:
                        System.out.println("See you again!");
                        System.exit(0);
                        break;
                }
            } while (true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
