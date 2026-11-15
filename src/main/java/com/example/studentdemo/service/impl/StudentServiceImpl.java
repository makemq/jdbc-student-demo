package com.example.studentdemo.service.impl;

import com.example.studentdemo.dao.StudentDao;
import com.example.studentdemo.dao.impl.StudentDaoImpl;
import com.example.studentdemo.entity.Student;
import com.example.studentdemo.service.StudentService;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao;

    public StudentServiceImpl() {
        this(new StudentDaoImpl());
    }

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> findAll() throws SQLException {
        return studentDao.findAll();
    }

    @Override
    public Student findById(int id) throws SQLException {
        if (id <= 0) throw new IllegalArgumentException("学号必须大于0");
        return studentDao.findById(id);
    }

    @Override
    public boolean addStudent(Student student) throws SQLException {
        validateStudent(student);
        return studentDao.addStudent(student);
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException {
        if (student == null || student.getId() <= 0) {
            throw new IllegalArgumentException("修改时必须提供有效学号");
        }
        validateStudent(student);
        return studentDao.updateStudent(student);
    }

    @Override
    public boolean deleteStudent(int id) throws SQLException {
        if (id <= 0) throw new IllegalArgumentException("学号必须大于0");
        return studentDao.deleteStudent(id);
    }

    private void validateStudent(Student student) {
        if (student == null) throw new IllegalArgumentException("学生信息不能为空");
        if (student.getName() == null || student.getName().isBlank()) {
            throw new IllegalArgumentException("姓名不能为空");
        }
        if (student.getAge() <= 0) throw new IllegalArgumentException("年龄必须大于0");
        if (Double.isNaN(student.getScore()) || Double.isInfinite(student.getScore())
                || student.getScore() < 0 || student.getScore() > 100) {
            throw new IllegalArgumentException("成绩必须在0到100之间");
        }
    }
}