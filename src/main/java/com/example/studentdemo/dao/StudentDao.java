package com.example.studentdemo.dao;

import com.example.studentdemo.entity.Student;
import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    List<Student> findAll() throws SQLException;
    Student findById(int id) throws SQLException;
    boolean addStudent(Student student) throws SQLException;
    boolean updateStudent(Student student) throws SQLException;
    boolean deleteStudent(int id) throws SQLException;
}