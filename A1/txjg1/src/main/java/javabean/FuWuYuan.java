package javabean;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author: jurui
 * @Email: acescen@foxmail.com
 * @ProjectName: txjg1
 * @Package: javabean
 * @Description:
 * @Date: Created in 15:03 2019-12-27
 */
public class FuWuYuan {
    public static String msg;
    public static int count = 0;
    public String chaoqiezi() {
        System.out.println("count="+count);
        if ((StringUtils.isBlank(msg)||"服务员正在服务".equals(msg)) && count < 3) {
            msg = "服务员正在服务";
            count++;
        } else {
            Chushi chushi = new Chushi();
            Chaoqiezi chaoqiezi = chushi.cookEggplant();
            if (chaoqiezi != null) {
                msg = "上了 " + (++count-3) + " 道炒茄子菜品";
            } else {
                msg = "不好意思，炒茄子卖完了！";
            }
        }
        System.out.println(msg);
        return msg;
    }
}
