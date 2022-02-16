package com.java.innerclass.bstatic;

public class OuterClass {
    public String name1;
    public static String name;

    /**
     * 静态内部类
     */
    public static class InnerClass{
        // 非静态属性
        public String name;
        // 静态属性
        public static int count;
        // 方法
        public void show(String name){
            System.out.println("参数name: " + name);
            System.out.println("内部类属性name: " + this.name);
            System.out.println("外部类静态属性name: " + OuterClass.name);
//            System.out.println("外部类非静态属性name: " + name1);
            // 不能访问外部类的非静态属性
        }
    }
}
