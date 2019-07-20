package com.bigdata.study.interfaceDemo;

/**
 * @author : wangshengyu
 * @date : 2019/6/23
 * @desc :
 */
public class MathClass implements IMath {
    private int num1;
    private int num2;
    public MathClass(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    public int sum(){
        return num1 + num2;
    }

    public int maxNum(int a, int b){
        if(a>b){
            return a;
        }else{
            return b;
        }
    }

}
