package com;

import com.model.Person;
import com.tools.Times;
import org.junit.Test;

import java.util.*;

public class Test01 {
    @Test
    public void testShallowClone() throws Exception{
        Person p1 = new Person("zhangsan",21);
        p1.setAddress("湖北省", "武汉市");
        Person p2 = (Person) p1.deepClone();
        System.out.println("p1:"+p1);
        System.out.println("p1.getPname:"+p1.getPname().hashCode());

        System.out.println("p2:"+p2);
        System.out.println("p2.getPname:"+p2.getPname().hashCode());

        p1.display("p1");
        p2.display("p2");
        p2.setAddress("湖北省", "荆州市");
        System.out.println("将复制之后的对象地址修改：");
        p1.display("p1");
        p2.display("p2");
    }


    @Test
    public void TestFactorial(){
        Times.test("f1" , ()->{
            int factorial = factorial(1000);
            System.out.println(factorial);
        });
    }

    private int factorial(int n){
        if (n == 1) return n;
        return n * factorial(n - 1);
    }

    @Test
    public void fib(){
        System.out.println(fib(5));
    }

    private int fib1(int n){
        if (n <= 0) return n;
        if (n == 1 || n == 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }


    private int fib(int n){
        return fib(n, 1,1);
    }

    private int fib(int n, int res1, int res2){
        if (n <= 0) return res1;
        return fib(n - 1, res2, res1 + res2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        String[] arr = new String[count];
        for(int i = 0; i < count; i++) {
            arr[i] = in.next();
        }

        Arrays.sort(arr, (o1, o2) -> {
            int index = 0;
            while (index < o1.length() && index < o2.length()) {
                char c1 = o1.charAt(index);
                char c2 = o2.charAt(index);
                if (c1 == c2) {
                    index++;
                    continue;
                }
                return (int)c1 - (int)c2;
            }
            if (index == o1.length() && index != o2.length()) return -1;
            else if (index != o1.length() && index == o2.length()) return 1;
            return 0;
        });

        for(int i = 0; i < count; i++) {
            System.out.println(arr[i]);
        }
    }

}
