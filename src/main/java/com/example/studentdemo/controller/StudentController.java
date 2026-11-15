package com.example.studentdemo.controller;

import com.example.studentdemo.entity.Student;
import com.example.studentdemo.service.StudentService;
import com.example.studentdemo.service.impl.StudentServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class StudentController {
    private final StudentService studentService;

    public StudentController() {
        this(new StudentServiceImpl());
    }

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    public void showAllStudents() {
        try {
            List<Student> students = studentService.findAll();
            System.out.println("查询成功，共 " + students.size() + " 名学生：");
            students.forEach(System.out::println);
        } catch (SQLException | IllegalArgumentException e) {
            System.out.println("查询失败：" + e.getMessage());
        }
    }

    public boolean addStudent(Student student) {
        try {
            boolean success = studentService.addStudent(student);
            System.out.println(success ? "新增成功，学号：" + student.getId() : "新增失败");
            return success;
        } catch (SQLException | IllegalArgumentException e) {
            System.out.println("新增失败：" + e.getMessage());
            return false;
        }
    }

    public boolean updateStudent(Student student) {
        try {
            boolean success = studentService.updateStudent(student);
            System.out.println(success ? "修改成功" : "修改失败：未找到该学号");
            return success;
        } catch (SQLException | IllegalArgumentException e) {
            System.out.println("修改失败：" + e.getMessage());
            return false;
        }
    }

    public void showStudentById(int id) {
        try {
            Student student = studentService.findById(id);
            System.out.println(student == null ? "查询失败：未找到学号 " + id : "查询成功：" + student);
        } catch (SQLException | IllegalArgumentException e) {
            System.out.println("查询失败：" + e.getMessage());
        }
    }

    public boolean deleteStudent(int id) {
        try {
            boolean success = studentService.deleteStudent(id);
            System.out.println(success ? "删除成功" : "删除失败：未找到该学号");
            return success;
        } catch (SQLException | IllegalArgumentException e) {
            System.out.println("删除失败：" + e.getMessage());
            return false;
        }
    }
}