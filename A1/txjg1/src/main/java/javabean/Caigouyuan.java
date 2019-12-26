package javabean;

import dao.Kucun;
import javabean.Qiezi;

/**
 * @Author: jurui
 * @Email: acescen@foxmail.com
 * @ProjectName: txjg1
 * @Package: service
 * @Description:
 * @Date: Created in 15:30 2019-12-25
 */
public class Caigouyuan {
    private static Kucun kucun;

    static {
        kucun = new Kucun();
    }


    public Qiezi getQiezi() {
        System.out.println(kucun.getQieziNum());
        if (kucun.getQieziNum() > 0) {
            kucun.subtractQiezi();
            return new Qiezi();
        } else {
            return null;
        }
    }

}
