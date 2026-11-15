package org.jisu.service;

import org.jisu.pojo.Student;
import java.sql.SQLException;
import java.util.List;

public interface StudentService {

    boolean addStudent(Student student) throws SQLException;

    List<Student> findAll() throws SQLException;

    Student findById(String id) throws SQLException;

    boolean updateStudent(Student student) throws SQLException;

    boolean deleteStudent(String id) throws SQLException;
}
