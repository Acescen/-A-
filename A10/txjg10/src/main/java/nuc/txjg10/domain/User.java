package nuc.txjg10.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jurui
 * @Email: acescen@foxmail.com
 * @ProjectName: txjg10
 * @Package: nuc.txjg10.domain
 * @Description:
 * @Date: Created in 14:57 2019-12-26
 */
@Data
public class User {
    public static List<User> users = new ArrayList<>();

    private String name;
    private String sex;
    private String phoneNum;
    private String idCard;
}
