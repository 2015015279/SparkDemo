package com.bigdata.study.innerDemo.moreExtendDemo;

/**
 * @author : wangshengyu
 * @date : 2019/6/23
 * @desc :  使用内部类，实现多重继承
 */
public class Son {
    //内部类继承Father类
    class Fathher_1 extends Father{
        public int strong(){
            return super.strong()+1;
        }
    }
    //内部类继承Mother类
    class Mother_1 extends Mother{
        public int kind(){
            return super.kind()-2;
        }
    }

    public int getStrong(){
        return new Fathher_1().strong();
    }

    public int getKind(){
        return new Mother_1().kind();
    }
}
