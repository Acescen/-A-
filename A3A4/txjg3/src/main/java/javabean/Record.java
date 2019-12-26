package javabean;

import lombok.Data;

import java.util.Date;

/**
 * @Author: jurui
 * @Email: acescen@foxmail.com
 * @ProjectName: txjg2
 * @Package: javabean
 * @Description:
 * @Date: Created in 16:34 2019-12-25
 */
@Data
public class Record {
    private Integer id;
    private String username;
    private String name;
    private Date createtime;
}
