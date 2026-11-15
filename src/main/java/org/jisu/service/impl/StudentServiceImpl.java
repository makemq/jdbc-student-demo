package org.jisu.service.impl;

import org.jisu.dao.StudentDao;
import org.jisu.service.StudentService;


import org.jisu.dao.StudentDao;
import org.jisu.pojo.Student;
import org.jisu.service.StudentService;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public boolean addStudent(Student student) throws SQLException {
        if (student.getScore() < 0 || student.getScore() > 100) {
            System.out.println("成绩必须在0到100之间！");
            return false;
        }
        return studentDao.addStudent(student) > 0;
    }

    @Override
    public List<Student> findAll() throws SQLException {
        return studentDao.findAll();
    }

    @Override
    public Student findById(String id) throws SQLException {
        return studentDao.findById(id);
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException {
        if (student.getScore() < 0 || student.getScore() > 100) {
            System.out.println("成绩必须在0到100之间！");
            return false;
        }
        return studentDao.updateStudent(student) > 0;
    }

    @Override
    public boolean deleteStudent(String id) throws SQLException {
        return studentDao.deleteStudent(id) > 0;
    }
}
