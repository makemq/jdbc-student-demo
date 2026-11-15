package org.jisu.app;


import org.jisu.controller.StudentController;
import org.jisu.dao.StudentDao;
import org.jisu.dao.impl.StudentDaoImpl;
import org.jisu.service.StudentService;
import org.jisu.service.impl.StudentServiceImpl;



import org.jisu.pojo.Student;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        // 在Main中创建具体实现类，并按接口类型传递给上层
        StudentDao studentDao = new StudentDaoImpl();
        StudentService studentService = new StudentServiceImpl(studentDao);
        StudentController controller = new StudentController(studentService);
        try {
            // 1. 查询全部学生
            System.out.println("===== 原有学生信息 =====");
            controller.showAllStudents();

            // 2. 新增学生
            System.out.println("===== 新增学生 =====");

            Student zhaoliu = new Student(null, "赵六", 20, 94.0);
            controller.addStudent(zhaoliu);


            System.out.println("-> 新增成功，数据库分配的 ID 为：" + zhaoliu.getId());

            // 3. 根据真实 ID 查询赵六
            System.out.println("===== 查询赵六 =====");

            controller.showStudentById(zhaoliu.getId());

            // 4. 修改学生信息
            System.out.println("===== 修改赵六成绩 =====");
            zhaoliu.setScore(95.0); // 直接修改对象的分数

            controller.updateStudent(zhaoliu);

            // 再次查询，检查修改结果
            controller.showStudentById(zhaoliu.getId());

            // 5. 删除学生
            System.out.println("===== 删除赵六 =====");

            controller.deleteStudent(zhaoliu.getId());

            // 6. 再次查询全部学生
            System.out.println("===== 删除后的学生信息 =====");
            controller.showAllStudents();

        } catch (SQLException e) {
            System.out.println("数据库操作失败：" + e.getMessage());
            e.printStackTrace();
        }

    }
}
