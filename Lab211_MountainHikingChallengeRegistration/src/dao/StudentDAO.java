/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Student;
import tools.Acceptable;

/**
 *
 * @author khoac
 */
public class StudentDAO implements IStudentDAO {

    private List<Student> studentList = new ArrayList<>();
    private final FileManager fileManager;

    public StudentDAO() {
        this.fileManager = new FileManager("registrations.dat");
        loadData();
    }

    private void loadData() {
        List<Student> students = fileManager.readObjectsFromFile();
        if (students.isEmpty()) {
            System.out.println("No student have register yet!");
        } else {
            studentList.addAll(students);
        }
    }

    @Override
    public List<Student> getStudents() {
        if (studentList == null) {
            return new ArrayList<>();
        }
        List<Student> sortedList = new ArrayList<>(studentList);
        Collections.sort(sortedList, (e1, e2) -> e1.getId().compareTo(e2.getId()));
        return sortedList;
    }

    @Override
    public Student getStudentById(String id) throws Exception {
        if (studentList == null || studentList.isEmpty()) {
            getStudents();
        }
        Student student = studentList.stream().filter(e -> e.getId().equalsIgnoreCase(id)).findAny().orElse(null);
        return student;
    }

    @Override
    public void addStudent(Student student) throws Exception {
        studentList.add(student);
    }

    @Override
    public void updateStudent(Student student) throws Exception {
        Student existingStudent = getStudentById(student.getId());
        if (existingStudent == null) {
            throw new Exception("This student has not registered yet!");
        }
        if (student.getName() != null) {
            existingStudent.setName(student.getName());
        }
        if (student.getPhone() != null) {
            existingStudent.setPhone(student.getPhone());
        }
        if (student.getEmail() != null) {
            existingStudent.setEmail(student.getEmail());
        }
        if (student.getMountainCode() != null) {
            existingStudent.setMountainCode(student.getMountainCode());
        }
    }

    @Override
    public void removeStudent(Student student) throws Exception {
        if (!Acceptable.isValid(student.getId(), Acceptable.STU_ID_VALID)) {
            throw new Exception("Invalid Student ID.");
        }
        Student stu = getStudentById(student.getId());
        if (stu == null) {
            throw new Exception("This student has not registered yet.");
        }
        studentList.remove(stu);
    }

    @Override
    public void saveStudentList() throws Exception {
        fileManager.saveOjectsToFile(studentList);
    }

    @Override
    public List<Student> search(Predicate<Student> predicate) throws Exception {
        return studentList.stream().filter(student -> predicate.test(student)).collect(Collectors.toList());
    }

    @Override
    public void getStatistics() throws Exception {
        getStudents();
        if (studentList.isEmpty()) {
            System.out.println("No students have registered yet.");
            return;
        }
        
        Map<String, int[]> mountainStats = new HashMap<>();
        double defaultFee = 6000000;
        for (Student student : studentList) {
            String mountainCode = student.getMountainCode();
            double tuitionFee = defaultFee;
            String phone = student.getPhone();
            if (phone != null){
                if(phone.matches(Acceptable.VIETTEL_VALID)||phone.matches(Acceptable.VNPT_VALID)){
                    tuitionFee = defaultFee*0.65;
                }
            }
            mountainStats.putIfAbsent(mountainCode, new int[]{0, 0});
            mountainStats.get(mountainCode)[0]++;  
            mountainStats.get(mountainCode)[1] += tuitionFee;  
        }
      
        System.out.println("Statistics of Registration by Mountain Peak:");
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-12s | %-25s | %-15s%n", "Peak Name", "Number of Participants", "Total Cost");
        System.out.println("------------------------------------------------------------");

        for (Map.Entry<String, int[]> entry : mountainStats.entrySet()) {
            String mountainCode = entry.getKey();
            int count = entry.getValue()[0];
            double totalTuitionFee = entry.getValue()[1];

            System.out.printf("%-12s | %-25d | %,-15.0f%n", mountainCode, count, totalTuitionFee);
        }

        System.out.println("------------------------------------------------------------");
    }

}
