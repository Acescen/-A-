package javabean;

/**
 * @Author: jurui
 * @Email: acescen@foxmail.com
 * @ProjectName: txjg1
 * @Package: service
 * @Description:
 * @Date: Created in 15:06 2019-12-25
 */
public class Chushi {
    private static Caigouyuan caigouyuan;
    static {
        caigouyuan = new Caigouyuan();
    }


    public Chaoqiezi cookEggplant() {
        Qiezi qiezi = caigouyuan.getQiezi();
        if (qiezi == null) {
            return null;
        }
        return new Chaoqiezi(qiezi);
    }
}
