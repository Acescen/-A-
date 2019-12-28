package dao;

import javabean.Record;
import javabean.User;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: jurui
 * @Email: acescen@foxmail.com
 * @ProjectName: txjg1
 * @Package: dao
 * @Description:
 * @Date: Created in 15:42 2019-12-25
 */
public class UserDao {
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

    public boolean add(User user) {
        try {
            int flag1 = stmt.executeUpdate("insert into txjg2user(username,name,password) values (" + "\'" + user.getUsername() + "\'" + "," + "\'" + user.getName() + "\'" + "," + "\'" + user.getPassword() + "\'" + ")");
            int flag2 = stmt.executeUpdate("insert into txjg2record(username,name,createtime) values (" + "\'" + user.getUsername() + "\'" + "," + "\'" + user.getName() + "\'" + "," + "now()" + ")");
            //如果有数据，rs.next()返回true
            if (flag1 > 0 && flag2 > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<User> getUserList() {
        List<User> users = new ArrayList<>();
        try {
            rs = stmt.executeQuery("select * from txjg2user");
            //如果有数据，rs.next()返回true
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));

                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public List<Record> getRecordList() {
        List<Record> records = new ArrayList<>();
        try {
            rs = stmt.executeQuery("select * from txjg2record");
            //如果有数据，rs.next()返回true
            while (rs.next()) {
                Record record = new Record();
                record.setId(rs.getInt("id"));
                record.setUsername(rs.getString("username"));
                record.setName(rs.getString("name"));
                record.setCreatetime(rs.getTimestamp("createtime"));

                records.add(record);
            }
            return records;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }
}
