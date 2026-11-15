package org.jisu.dao.impl;

import org.jisu.dao.StudentDao;
import org.jisu.pojo.Student;
import org.jisu.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    // 新增 (已修改)
    // 新增
    @Override
    public int addStudent(Student student) throws SQLException {
        String sql = "INSERT INTO student(name, age, score) VALUES (?, ?, ?)";

        // 修改这里：加上 Statement.RETURN_GENERATED_KEYS
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setDouble(3, student.getScore());

            int rows = ps.executeUpdate();

            // 新增部分：获取数据库自动生成的 ID，并回填给 student 对象
            if (rows > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        // 把数据库生成的 5 赋值给 Java 对象！
                        // 因为你的 Student 类 id 是 String 类型，这里用 getString 或 getLong 转一下
                        student.setId(generatedKeys.getString(1));
                    }
                }
            }
            return rows;
        }
    }

    // 查询全部
    @Override
    public List<Student> findAll() throws SQLException {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT id, name, age, score FROM student";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Student student = new Student(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getDouble("score")
                );
                list.add(student);
            }
        }

        return list;
    }

    // 根据学号查询
    @Override
    public Student findById(String id) throws SQLException {
        String sql = "SELECT id, name, age, score FROM student WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Student(
                            rs.getString("id"),
                            rs.getString("name"),
                            rs.getInt("age"),
                            rs.getDouble("score")
                    );
                }
            }
        }

        return null;
    }

    // 修改
    @Override
    public int updateStudent(Student student) throws SQLException {
        String sql = "UPDATE student SET name = ?, age = ?, score = ? WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setDouble(3, student.getScore());
            ps.setString(4, student.getId());

            return ps.executeUpdate();
        }
    }

    // 删除
    @Override
    public int deleteStudent(String id) throws SQLException {
        String sql = "DELETE FROM student WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);

            return ps.executeUpdate();
        }
    }
}