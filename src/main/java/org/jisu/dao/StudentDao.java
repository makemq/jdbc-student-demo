package org.jisu.dao;

import org.jisu.pojo.Student;
import java.sql.SQLException;
import java.util.List;

public interface StudentDao {

    int addStudent(Student student) throws SQLException;

    List<Student> findAll() throws SQLException;

    Student findById(String id) throws SQLException;

    int updateStudent(Student student) throws SQLException;

    int deleteStudent(String id) throws SQLException;
}
