package com.hp.service;

import com.hp.entity.Customer;
import com.hp.entity.CustomerData;
import com.hp.util.ATMDemo;

import java.util.ArrayList;
import java.util.Scanner;

//此类是  完成 客户的 所有业务  (增删改查)
public class CustomerService {
    //成员变量
    private ArrayList<Customer> customerList;
    private Customer customerNow;
    private Scanner scanner;

    //1、登录  判断账户密码是否正确
    public void checkPwd(String cardId, String password) {
        //对数据初始化
        CustomerData customerData = CustomerData.getInstance();
        customerList = customerData.getCustomerList();
        //1)拿到 cardId中的账户名 和  password 对 CustomerList中的数据进行对比
       /* System.out.println("cardId = " + cardId);
        System.out.println("password = " + password);*/

        for (Customer customer : customerList) {
            if (customer.getAccount().equals(cardId) && customer.getPassword().equals(password)) {
                //拿出这个用户
                customerNow = customer;
                //账户密码正确
                System.out.println("欢迎" + customer.getCname() + "顾客登录！请注意您的安全");
                //一级选择界面
                ATMDemo.oneOption();
                Scanner scanner = new Scanner(System.in);
                String option = scanner.nextLine();
                oneOption(option);

            }
        }
    }

    //选择
    private void oneOption(String option) {
        switch (option) {
            case "1":
                System.out.println("余额查询");
                //查询余额
                doSelectMoney();
                //当按下1时 回退到一级选择界面
                goOneHome();
                break;
            case "2":
                //System.out.println("取款");
                ATMDemo.withdrawalOpt();//取款页面
                System.out.println("\t");
                //取款
                doWithdrawal();
                goOneHome();
                break;
            case "3":
                System.out.println("转账");
                goOneHome();
                break;
            case "4":
                System.out.println("存款");
                //存款操作
                cunkuan();
                goOneHome();
                break;
            case "5":
                System.out.println("退卡");
                break;
            default:
                System.out.println("对不起,您选择的功能有误!");
                break;

        }
    }

    //存款操作
    private void cunkuan() {
        System.out.println("请输入存款金额：");
        scanner = new Scanner(System.in);
        Double money = scanner.nextDouble();
        System.out.println("存款成功!余额为" + (customerNow.getMoney() + money));

    }

    //取款操作
    private void doWithdrawal() {
        scanner = new Scanner(System.in);
        Double goMoney = scanner.nextDouble();
        //String goMoney = scanner.nextLine();
        if (goMoney == 1) {
            System.out.println("请及时拿走现金 100元");
            System.out.println("*********************************");
            System.out.println("您的余额为 " + (customerNow.getMoney() - 100) + "元");
        } else if (goMoney == 2) {
            System.out.println("请及时拿走现金 200元");
            System.out.println("*********************************");
            System.out.println("您的余额为 " + (customerNow.getMoney() - 200) + "元");
        } else if (goMoney == 3) {
            System.out.println("请及时拿走现金 300元");
            System.out.println("*********************************");
            System.out.println("您的余额为 " + (customerNow.getMoney() - 300) + "元");
        } else if (goMoney == 4) {
            System.out.println("请及时拿走现金 500元");
            System.out.println("*********************************");
            System.out.println("您的余额为 " + (customerNow.getMoney() - 500) + "元");
        } else if (goMoney == 5) {
            System.out.println("请及时拿走现金 800元");
            System.out.println("*********************************");
            System.out.println("您的余额为 " + (customerNow.getMoney() - 800) + "元");
        } else if (goMoney == 6) {
            System.out.println("请及时拿走现金 1000元");
            System.out.println("*********************************");
            System.out.println("您的余额为 " + (customerNow.getMoney() - 1000) + "元");
        } else if (goMoney == 7) {
            System.out.println("请及时拿走现金 2000元");
            System.out.println("*********************************");
            System.out.println("您的余额为 " + (customerNow.getMoney() - 2000) + "元");

        } else if (goMoney == 8) {

            System.out.println("其他");
            Scanner other = new Scanner(System.in);
            double v = other.nextDouble();
            if(v<customerNow.getMoney()) {
                System.out.println("请及时拿走现金" + v + "元");

                System.out.println("您的余额为" + (customerNow.getMoney() - v));
            }else{
                System.out.println("您的余额不足!!! 请选择其他业务");
            }
        } else {
            System.out.println("请选择正确序号");
        }

    }

    //查询余额
    private void doSelectMoney() {
        double money = customerNow.getMoney();
        System.out.println("余额是" + money + "元");

    }

    //返回选择界面
    private void goOneHome() {
        ATMDemo.oneOption();
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        System.out.println("option = " + option);
        oneOption(option);//递归算法
    }
}
