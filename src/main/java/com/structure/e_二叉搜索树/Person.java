package com.structure.e_二叉搜索树;

/**
 * @Author: xiehongyu
 * @Date: 2021/8/17 19:56
 */
public class Person {

    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "age=" + age ;
    }
}
