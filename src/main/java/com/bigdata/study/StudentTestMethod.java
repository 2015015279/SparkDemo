package com.bigdata.study;

/**
 * @author : wangshengyu
 * @date : 2019/6/22
 * @desc :methodName({paramList},paramType…paramName)
 *
 * 其中，methodName 表示方法名称；paramList 表示方法的固定参数列表；
 * paramType 表示可变参数的类型；
 * … 是声明可变参数的标识；
 * paramName 表示可变参数名称。
 */
public class StudentTestMethod {
    public void print(String...names){
        int count = names.length;
        System.out.println("本次参加考试的有\"+count+\"人，名单如下：");
        for(int i=0; i<count; i++){
            System.out.println(names[i]);
        }
    }

    public static void main(String[] args) {
        StudentTestMethod student=new StudentTestMethod();
        student.print("zhangsan", "lisi", "wangwu");
    }
}
