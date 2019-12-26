package dao;

import java.sql.*;

/**
 * @Author: jurui
 * @Email: acescen@foxmail.com
 * @ProjectName: txjg1
 * @Package: dao
 * @Description:
 * @Date: Created in 15:42 2019-12-25
 */
public class Kucun {
    private static final String URL = "jdbc:mysql://localhost:3306/tixijiegou?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2b8";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    private static Connection conn;
    private static Statement stmt;
    private static ResultSet rs;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public int getQieziNum() {
        try {
            rs = stmt.executeQuery("SELECT num FROM txjg1 t where t.name='qiezi'");
            //如果有数据，rs.next()返回true
            while (rs.next()) {
                return rs.getInt("num");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void subtractQiezi() {

        try {
            stmt.executeUpdate("update txjg1 t set t.num=t.num-1 where t.name='qiezi'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
