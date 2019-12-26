package javabean;

import dao.UserDao;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @Author: jurui
 * @Email: acescen@foxmail.com
 * @ProjectName: txjg3
 * @Package: javabean
 * @Description:
 * @Date: Created in 10:08 2019-12-26
 */
public class UserOpt {
    private List<User> users;
    private List<Record> records;
    private static UserDao userDao;
    private static String msg;

    static {
        userDao = new UserDao();
    }

    public static String getMsg() {
        return msg;
    }

    public List<User> getUsers() {
        users = userDao.getUserList();
        return users;
    }

    public List<Record> getRecords() {
        records = userDao.getRecordList();
        return records;
    }

    public void addUser() {
        User user = new User("Test" + new Random().nextInt(90),
                "用户" + new Random().nextInt(90), "123456");


        boolean flag = userDao.add(user);

        if (flag) {
            msg = "添加成功！";
        } else {
            msg = "添加失败！";
        }
    }

}
