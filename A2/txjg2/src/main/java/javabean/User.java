package javabean;

import lombok.Data;

/**
 * @Author: jurui
 * @Email: acescen@foxmail.com
 * @ProjectName: txjg2
 * @Package: javabean
 * @Description:
 * @Date: Created in 16:23 2019-12-25
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String name;
    private String password;

    public User(String username, String name, String password) {
        this.username = username;
        this.name = name;
        this.password = password;
    }

    public User() {
    }

}
