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
 * @Date: Created in 15:11 2019-12-26
 */
@Data
public class Record {
    public static List<Record> records = new ArrayList<>();

    private String name;
    private String sex;
    private String phoneNum;
    private String idCard;
    private String msg;
    private String OptionTime;
}
