package com.java.innerclass.amember;

public class OuterClass {
    public String name;

    public class InnerClass{
        public String name;
        public void show(String name){
            System.out.println("参数name : " + name);
            System.out.println("内部类name : " + this.name);
            System.out.println("外部类name : " + OuterClass.this.name);
        }
    }
}
