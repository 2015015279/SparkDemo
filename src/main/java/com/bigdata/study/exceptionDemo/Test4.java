package com.bigdata.study.exceptionDemo;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author : wangshengyu
 * @date : 2019/6/23
 * @desc :
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try{
            System.out.println("请输入班级总人数：");
            int count = input.nextInt();
            System.out.println("请输入班级总成绩树：");
            int score = input.nextInt();
            int avg = score/count;
            System.out.println("本次考试平均分："+avg);
        }
        catch (InputMismatchException e1){
            System.out.println("输入数值有误！");
        }
        catch(ArithmeticException e2) {
            System.out.println("输入的总人数不能为0！");
        }
        catch(Exception e3){
            e3.printStackTrace();
            System.out.println("发生错误！"+e3.getMessage());
        }
    }
}
