package nuc.products;

import nuc.HeSuanZhongXin;

/**
 * @Author: jurui
 * @Email: acescen@foxmail.com
 * @ProjectName: txjg23
 * @Package: PACKAGE_NAME
 * @Description:
 * @Date: Created in 12:14 2019-12-26
 */
public abstract  class Product {
    //引用核算中心
    public HeSuanZhongXin jingXiaoShang;
    //核算产品
    public abstract void heSuanChanPin();
}
