package com.interview.java8;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class Reflect {

    @Test
    public void testReflect1() throws ClassNotFoundException {
        Class<?> c = Class.forName("com.structure.ArrayList");
        Field[] fs = c.getDeclaredFields(); // 获取所有属性
        StringBuffer sb = new StringBuffer();
        // 最外边的public定义
        sb.append(Modifier.toString(c.getModifiers()) + " class " + c.getSimpleName() + "{\n");
        for (Field f : fs) {
            sb.append("\t")
                    .append(Modifier.toString(f.getModifiers()) + " ") // 获得属性的修饰符
                    .append(f.getType().getSimpleName() + " ") // 属性的类型的名字
                    .append(f.getName() + ";\n"); // 属性的名字
            System.out.println(Modifier.toString(f.getModifiers()));
        }
        sb.append("}");
        System.out.println(sb);
    }


    @Test
    public void testReflect2() throws Exception {
        // 获取类
        Class<?> c = Class.forName("com.model.User");
        // 获取id属性
        Field id = c.getDeclaredField("id");
        // 实例化
        Object o = c.newInstance();
        // 打破封装？使用反射机制可以打破封装性，可以直接访问private修饰的属性
        id.setAccessible(true);
        id.set(o, 110);
        System.out.println(id.get(o));
    }

    @Test
    public void testReflect3() throws Exception {
        // 获取类
        Class<?> c = Class.forName("com.model.User");
        // 获取id属性
        Method[] methods = c.getMethods();
        StringBuffer sb = new StringBuffer();
        sb.append(Modifier.toString(c.getModifiers()))
                .append(" class ")
                .append(c.getSimpleName())
                .append("{\n");
        for (Method method : methods) {
            sb.append("\t")
                    .append(Modifier.toString(method.getModifiers()))
                    .append(" ")
                    .append(method.getReturnType())
                    .append(" ")
                    .append(method.getName())
                    .append("(");
            Parameter[] parameters = method.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                sb.append(parameters[i]);
                if (i < parameters.length - 1) sb.append(", ");
            }
            sb.append(");\n");
        }
        sb.append("}");
        System.out.println(sb);

    }
}
