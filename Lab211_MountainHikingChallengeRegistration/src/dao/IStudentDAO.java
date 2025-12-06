/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import java.util.function.Predicate;
import model.Student;

/**
 *
 * @author khoac
 */
public interface IStudentDAO {

    List<Student> getStudents();

    Student getStudentById(String id) throws Exception;

    void addStudent(Student student) throws Exception;

    void updateStudent(Student student) throws Exception;

    void removeStudent(Student student) throws Exception;

    void saveStudentList() throws Exception;

    List<Student> search(Predicate<Student> predicate) throws Exception;

    void getStatistics() throws Exception;
}
