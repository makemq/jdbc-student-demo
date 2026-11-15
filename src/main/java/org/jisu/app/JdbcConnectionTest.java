package org.jisu.app;
import org.jisu.util.DBUtil;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcConnectionTest {

    public static void main(String[] args) {

        try (Connection connection = DBUtil.getConnection()) {
            System.out.println("数据库连接成功！");
            System.out.println("当前连接状态：" + !connection.isClosed());

        } catch (SQLException e) {
            System.out.println("数据库连接失败！");
            e.printStackTrace();
        }
    }
}
