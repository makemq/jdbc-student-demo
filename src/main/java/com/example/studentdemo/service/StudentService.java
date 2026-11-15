package com.example.studentdemo.service;

import com.example.studentdemo.entity.Student;
import java.sql.SQLException;
import java.util.List;

public interface StudentService {
    List<Student> findAll() throws SQLException;
    Student findById(int id) throws SQLException;
    boolean addStudent(Student student) throws SQLException;
    boolean updateStudent(Student student) throws SQLException;
    boolean deleteStudent(int id) throws SQLException;
}