package org.jisu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    // 根据自己的MySQL配置修改
    private static String URL =
            "jdbc:mysql://localhost:3306/course_db"
                    + "?sslMode=DISABLED"
                    + "&connectionTimeZone=Asia/Shanghai"
                    + "&allowPublicKeyRetrieval=true";

    private static String USER = "root";

    // 替换为自己的MySQL密码
    private static String PASSWORD = "123456";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
