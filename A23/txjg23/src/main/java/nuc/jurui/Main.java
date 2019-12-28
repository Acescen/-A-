package nuc.jurui;

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
        Product xingHuaCun = new XingHuaCun();
        Product zhuYeQing = new ZhuYeQing();
        Product fenJiu = new FenJiu();

        System.out.println("开始核算");
        System.out.println();
        System.out.println("开始核算超市日均营收----------------");
        //核算超市的杏花村日均应收额
        xingHuaCun.jingXiaoShang = new ChaoShi();
        xingHuaCun.heSuan();
        xingHuaCun.jingXiaoShang.heSuan();

        //核算超市的竹叶青日均应收额
        zhuYeQing.jingXiaoShang = new ChaoShi();
        zhuYeQing.heSuan();
        zhuYeQing.jingXiaoShang.heSuan();

        //核算超市的汾酒日均应收额
        fenJiu.jingXiaoShang = new ChaoShi();
        fenJiu.heSuan();
        fenJiu.jingXiaoShang.heSuan();

////////////////////////////////////////////////////////
        System.out.println("开始核算专卖店日均营收----------------");
        //核算专卖店的杏花村日均应收额
        xingHuaCun.jingXiaoShang = new ZhuanMaiDian();
        xingHuaCun.heSuan();
        xingHuaCun.jingXiaoShang.heSuan();

        //核算专卖店的竹叶青日均应收额
        zhuYeQing.jingXiaoShang = new ZhuanMaiDian();
        zhuYeQing.heSuan();
        zhuYeQing.jingXiaoShang.heSuan();

        //核算专卖店的汾酒日均应收额
        fenJiu.jingXiaoShang = new ZhuanMaiDian();
        fenJiu.heSuan();
        fenJiu.jingXiaoShang.heSuan();
////////////////////////////////////////////////////////
        System.out.println("开始核算自营店日均营收----------------");

        //核算自营店的杏花村日均应收额
        xingHuaCun.jingXiaoShang = new ZiYingDian();
        xingHuaCun.heSuan();
        xingHuaCun.jingXiaoShang.heSuan();

        //核算自营店的竹叶青日均应收额
        zhuYeQing.jingXiaoShang = new ZiYingDian();
        zhuYeQing.heSuan();
        zhuYeQing.jingXiaoShang.heSuan();

        //核算自营店的汾酒日均应收额
        fenJiu.jingXiaoShang = new ZiYingDian();
        fenJiu.heSuan();
        fenJiu.jingXiaoShang.heSuan();


    }
}
