package com.extend.innerclass.amember;

public class Program {

    public static void main(String[] args) {
        // 1. 实例化外部类
        OuterClass outerClass = new OuterClass();
        // 2. 访问外部类属性
        outerClass.name = "OuterClass";
        // 3. 实例化内部类
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        // 4. 访问外部类属性
        innerClass.name = "InnerClass";
        // 5. 访问外部类方法
        innerClass.show("parameter");
    }
}
