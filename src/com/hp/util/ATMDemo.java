package com.hp.util;
/*
* 文本信息的工具类
* */
public class ATMDemo {

    //welcome界面
    /*
    * static 修饰方法，1.可以直接被类名.方法（）调用
    * 2、在内存中独一份，其他修改，他会跟着修改
    * 关于static 静态代码块， 他一般适用于 界面场景的提前加载，如 王者荣耀中 峡谷的轮廓永远优先于英雄出现
    *
    * static {
    *   //这是 静态代码块
    * }
    * */
    public static void welcome() {
        System.out.println("*****************************************");
        System.out.println("***************ATM取款机******************");
        System.out.println("***********欢迎您使用ATM取款机*************");
        System.out.println("*****************************************");
    }
}
