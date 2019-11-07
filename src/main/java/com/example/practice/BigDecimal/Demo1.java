package com.example.practice.BigDecimal;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 1.使用参数为float或double的BigDecimal创建对象会丢失精度。因此强烈建议不要使用参数为float或double的BigDecimal创建对象。
 * 如：1.745->1.75,0.745->0.74(没有四舍五入)
 * 2.建议使用String的类型来转如BigDecimal bd = new BigDecimal("3.33")即可;
 * 3.ROUND_DOWN：只截取，不四舍五入
 *   ROUND_UP：无论第三位是大于小于5都进1，但是0的话，不进位。如1.741->1.75 ; 1.740->1.74
 */
public class Demo1 {
    public static void main(String[] args) {
//        double data = 20.23677;
        String data1 ="1.744";
        BigDecimal bd = new BigDecimal(data1);
        BigDecimal setScale1 = bd.setScale(2,bd.ROUND_DOWN);//20.23,只是简单的截取字符，不舍入
        BigDecimal setScale2 = bd.setScale(2,bd.ROUND_UP);
        BigDecimal setScale3 = bd.setScale(2,bd.ROUND_HALF_UP);
        BigDecimal setScale4 = bd.setScale(2,bd.ROUND_HALF_DOWN);

//        DecimalFormat df = new DecimalFormat("#.00");
//        System.out.println(df.format(20.345));
        System.out.println(setScale1.doubleValue());
        System.out.println(setScale2.doubleValue());
        System.out.println(setScale3.doubleValue());
        System.out.println(setScale4.doubleValue());
    }
}
