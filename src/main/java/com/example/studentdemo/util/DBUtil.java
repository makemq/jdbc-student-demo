package com.example.studentdemo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接工具。可通过环境变量覆盖默认连接配置。
 */
public final class DBUtil {
    private static final String URL = env("DB_URL",
            "jdbc:mysql://localhost:3306/student_db?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf8");
    private static final String USER = env("DB_USER", "root");
    private static final String PASSWORD = env("DB_PASSWORD", "root");

    private DBUtil() {
    }

    private static String env(String key, String defaultValue) {
        String value = System.getenv(key);
        return value == null || value.isBlank() ? defaultValue : value;
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}