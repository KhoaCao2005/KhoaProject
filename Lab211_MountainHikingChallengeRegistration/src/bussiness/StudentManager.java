/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussiness;

import dao.IStudentDAO;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import model.Student;
import tools.Acceptable;
import tools.Inputter;
import tools.Menu;

/**
 *
 * @author khoac
 */
public class StudentManager {

    IStudentDAO studentDAO;
    private MountainManager mountainManager = new MountainManager();
    public static boolean isSaved = true;

    public StudentManager(IStudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public void processForRegistration() {
        boolean stop = true;
        try {
            do {
                System.out.println(String.join("", Collections.nCopies(32, "-")));
                System.out.println("|1. NEW REGISTER!              |");
                System.out.println("|2. UPDATE REGISTRATION!       |");
                System.out.println("|3. DISPLAY REGISTRATION LIST! |");
                System.out.println("|4. DELETE REGISTRATION!       |");
                System.out.println("|5. SEARCH (NAME OR CAMPUS)!   |");
                System.out.println("|6. DISPLAY STATISTIC!         |");
                System.out.println("|7. SAVE!                      |");
                System.out.println("|8. >>BACK TO MAIN MENU<<      |");
                System.out.println(String.join("", Collections.nCopies(32, "-")));
                System.out.println("Please choose: ");
                int choice = Inputter.getInt();
                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        updateStudent();
                        break;
                    case 3:
                        System.out.println("Students List: ");
                        printList(studentDAO.getStudents());
                        break;
                    case 4:
                        deleteStudent();
                        break;
                    case 5:
                        searchStudent();
                        break;
                    case 6:
                        showStatistics();
                        break;
                    case 7:
                        save();
                        break;
                    case 8:
                        if (isSaved == false) {
                            System.out.println("You have unsaved changes. Do you want to exit without saving? (Y/N)");
                            String confirmation = Inputter.getString().trim().toLowerCase();
                            if (confirmation.equals("n")) {
                                System.out.println("Do you want to save? (Y/N)");
                                String temp = Inputter.getString().trim().toLowerCase();
                                if (temp.equals("y")) {
                                    save();
                                    stop = false;
                                }
                            } else {
                                stop = false;
                            }
                        } else {
                            stop = false;
                        }
                        break;

                    default:
                        System.out.println("Choice invalid");
                        break;
                }
            } while (stop);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Student inputStudent() throws Exception {
        String id = Inputter.inputAndLoop("Enter Student ID: ", Acceptable.STU_ID_VALID);
        String name = Inputter.inputAndLoop("Enter Student Name: ", Acceptable.NAME_VALID);
        String phone = Inputter.inputAndLoop("Enter Student Phone: ", Acceptable.PHONE_VALID);
        String email = Inputter.inputAndLoop("Enter Student Email: ", Acceptable.EMAIL_VALID);
        String mountainCode;

        do {
            mountainCode = Inputter.getString("Enter Mountain Code: ");
            if (!mountainManager.isValidMountainCode(mountainCode)) {
                System.out.println("Invalid Mountain Code! Please enter a valid code.");
            }
        } while (!mountainManager.isValidMountainCode(mountainCode));
        return new Student(id, name, phone, email, mountainCode);
    }

    public void changeStudentInfo(Student student) throws Exception {
        String name = Inputter.inputAndLoop("Enter New Student Name: ", Acceptable.NAME_VALID);
        if (!name.isEmpty()) {
            student.setName(name);
        }
        String phone = Inputter.inputAndLoop("Enter New Student Phone: ", Acceptable.PHONE_VALID);
        if (!phone.isEmpty()) {
            student.setPhone(phone);
        }
        String email = Inputter.inputAndLoop("Enter New Student Email: ", Acceptable.EMAIL_VALID);
        if (!email.isEmpty()) {
            student.setEmail(email);
        }
        String mountainCode;
        do {
            mountainCode = Inputter.getString("Enter Mountain Code: ");
            if (!mountainManager.isValidMountainCode(mountainCode)) {
                System.out.println("Invalid Mountain Code! Please enter a valid code.");
            }
        } while (!mountainManager.isValidMountainCode(mountainCode));
        if (!mountainCode.isEmpty()) {
            student.setMountainCode(mountainCode);
        }
    }

    public void addStudent() {
        try {
            Student student = inputStudent();
            if (studentDAO.getStudentById(student.getId()) != null) {
                System.out.println("Exists!");
                return;
            } else {
                studentDAO.addStudent(student);
                System.out.println("Added!");
                isSaved = false;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updateStudent() {
        try {
            String id = Inputter.getString("Enter Student ID For Update: ");
            Student student = studentDAO.getStudentById(id);
            if (student == null) {
                System.out.println("Not Found");
                return;
            }
            changeStudentInfo(student);
            studentDAO.updateStudent(student);
            System.out.println("Updated!");
            isSaved = false;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void deleteStudent() {
        try {
            String id = Inputter.getString("Enter Student ID: ");
            Student student = studentDAO.getStudentById(id);
            if (student == null) {
                System.out.println("Student not found!");
                return;
            }
            System.out.println("Student Details:");
            System.out.println("Name: " + student.getName());
            System.out.println("Phone: " + student.getPhone());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Mountain Code: " + student.getMountainCode());
            System.out.print("Do you really want to delete this registration? (yes/no): ");
            String confirmation = Inputter.getString().trim().toLowerCase();
            if (confirmation.equals("yes")) {
                studentDAO.removeStudent(student);
                System.out.println("The registration has been successfully deleted.");
                isSaved = false;
            } else {
                System.out.println("The deletion has been canceled.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public List<Student> searchStudentName(String value) throws Exception {
        Predicate<Student> predicate = p -> p.getName().toLowerCase().
                contains(value.toLowerCase());
        return studentDAO.search(predicate);
    }

    public List<Student> searchStudentCampus(String value) throws Exception {
        Predicate<Student> predicate = student
                -> student.getId() != null
                && student.getId().length() >= 2
                && student.getId().substring(0, 2).equalsIgnoreCase(value);
        return studentDAO.search(predicate);
    }

    public void save() throws Exception {
        studentDAO.saveStudentList();
    }

    public void searchStudent() throws Exception {
        int choice;
        boolean stop = true;
        String value;
        try {
            do {
                System.out.println(String.join("", Collections.nCopies(30, "-")));
                System.out.println("|1. SEARCH BY NAME!          |");
                System.out.println("|2. FILTER BY CAMPUS!        |");
                System.out.println("|3. >>BACK TO REGISTRATION<< |");
                System.out.println("Please choose: ");
                choice = Inputter.getInt();
                switch (choice) {

                    case 1:
                        value = Inputter.getString("Enter student name:");
                        List<Student> students = searchStudentName(value);
                        if (!students.isEmpty()) {
                            printList(students);
                        } else {
                            System.out.format("The student with name:%s not found.%n", value);
                        }
                        break;
                    case 2:
                        value = Inputter.getString("Enter student campus:");
                        students = searchStudentCampus(value);
                        if (!students.isEmpty()) {
                            printList(students);
                        } else {
                            System.out.format("The students with campus:%s not found.%n", value);
                        }
                        break;

                    case 3:
                        stop = false;
                        break;
                    default:
                        System.out.println("Choice invalid");
                        break;
                }
            } while (stop);
        } catch (Exception e) {
            System.out.println(">>Error:" + e.getMessage());
        }
    }

    public void printList(List<Student> students) throws Exception {

        Menu.printHeaderForStudent();
        double defaultFee = 6000000;

        for (Student student : students) {
            double tuitionFee = defaultFee;
            String phone = student.getPhone();
            if (phone != null) {
                if (phone.matches(Acceptable.VIETTEL_VALID) || phone.matches(Acceptable.VNPT_VALID)) {
                    tuitionFee = defaultFee * 0.65;
                }
            }
            Menu.printRowForStudent(student.getId(), student.getName(), student.getPhone(),
                    student.getEmail(), student.getMountainCode(), tuitionFee);
        }
    }

    public void showStatistics() throws Exception {
        studentDAO.getStatistics();
    }
}
