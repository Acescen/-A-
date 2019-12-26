package nuc;

import nuc.jingxiaoshang.ChaoShi;
import nuc.products.Product;
import nuc.products.XingHuaCun;

/**
 * @Author: jurui
 * @Email: acescen@foxmail.com
 * @ProjectName: txjg23
 * @Package: nuc
 * @Description:
 * @Date: Created in 12:24 2019-12-26
 */
public class Main {
    public static void main(String[] args) {
        //核算超市的杏花村日均应收额
        Product xingHuaCun = new XingHuaCun();
        //设置核算经销商
        xingHuaCun.jingXiaoShang = new ChaoShi();

        xingHuaCun.heSuanChanPin();
        xingHuaCun.jingXiaoShang.heSuan();

    }
}
