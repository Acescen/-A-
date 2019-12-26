package javabean;

/**
 * @Author: jurui
 * @Email: acescen@foxmail.com
 * @ProjectName: txjg1
 * @Package: javabean
 * @Description:
 * @Date: Created in 15:32 2019-12-25
 */
public class Chaoqiezi {
    private Qiezi qiezi;

    private Chaoqiezi() {

    }

    public Chaoqiezi(Qiezi qiezi) {
        this.qiezi = qiezi;
    }

    @Override
    public String toString() {
        return "炒"+qiezi.toString();
    }
}
