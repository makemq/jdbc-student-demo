package com.example.studentdemo;

import com.example.studentdemo.controller.StudentController;
import com.example.studentdemo.entity.Student;

public class Main {
    public static void main(String[] args) {
        StudentController controller = new StudentController();

        System.out.println("========== 1. 查询全部学生 ==========");
        controller.showAllStudents();

        System.out.println("\n========== 2. 新增一名学生 ==========");
        Student student = new Student("张三", 20, 85.5);
        if (!controller.addStudent(student)) {
            System.out.println("新增未成功，后续测试终止。请检查数据库连接和表结构。");
            return;
        }

        System.out.println("\n========== 3. 修改该学生的成绩 ==========");
        student.setScore(92.0);
        controller.updateStudent(student);

        System.out.println("\n========== 4. 根据学号查询 ==========");
        controller.showStudentById(student.getId());

        System.out.println("\n========== 5. 删除该学生 ==========");
        controller.deleteStudent(student.getId());

        System.out.println("\n========== 6. 再次查询，验证删除结果 ==========");
        controller.showAllStudents();
    }
}