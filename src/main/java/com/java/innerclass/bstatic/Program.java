package com.java.innerclass.bstatic;

import com.java.innerclass.bstatic.OuterClass.InnerClass;
public class Program {

    public static void main(String[] args) {
        // 实例化内部类对象，直接实例化即可，不需要外部类的对象
        OuterClass.InnerClass innerClass = new OuterClass.InnerClass();
        // 通过导包的方式
        OuterClass.InnerClass innerClass1 = new InnerClass();
        // 成员访问
        OuterClass.name = "outerClass";
        innerClass.name = "innerClass";
        innerClass.show("parameter");
    }
}
