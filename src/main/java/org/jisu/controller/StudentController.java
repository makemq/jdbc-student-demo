package org.jisu.controller;

import org.jisu.service.StudentService;



import org.jisu.pojo.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // 新增
    public void addStudent(Student student) throws SQLException {
        if (studentService.addStudent(student)) {
            System.out.println("新增成功！");
        } else {
            System.out.println("新增失败！");
        }
    }

    // 查询全部
    public void showAllStudents() throws SQLException {
        List<Student> list = studentService.findAll();
        for (Student student : list) {
            System.out.println(student);
        }
    }

    // 根据学号查询
    public void showStudentById(String id) throws SQLException {
        Student student = studentService.findById(id);
        if (student == null) {
            System.out.println("没有找到该学生！");
        } else {
            System.out.println(student);
        }
    }

    // 修改
    public void updateStudent(Student student) throws SQLException {
        if (studentService.updateStudent(student)) {
            System.out.println("修改成功！");
        } else {
            System.out.println("修改失败！");
        }
    }

    // 删除
    public void deleteStudent(String id) throws SQLException {
        if (studentService.deleteStudent(id)) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
    }
}
