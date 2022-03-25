package com.algorithm.structure.算法.递归;

public class 汉诺塔 {

    public static void hanoi1(int n){
        leftToRight(n);
    }

    // 把n个圆盘从左移动到右
    private static void leftToRight(int n) {
        if (n == 1){
            System.out.println("move 1 from left to right");
            return;
        }
        leftToMid(n - 1);
        System.out.println("move " + n + " from left to right");
        midToRight(n - 1);
    }

    private static void leftToMid(int n) {
        if (n == 1){
            System.out.println("move 1 from left to mid");
            return;
        }
        leftToRight(n - 1);
        System.out.println("move " + n + " from left to mid");
        rightToMid(n - 1);
    }

    private static void midToRight(int n) {
        if (n == 1){
            System.out.println("move 1 from mid to right");
            return;
        }
        midToLeft(n - 1);
        System.out.println("move " + n + " from mid to right");
        leftToRight(n - 1);
    }

    private static void rightToMid(int n) {
        if (n == 1){
            System.out.println("move 1 from right to mid");
            return;
        }
        rightToLeft(n - 1);
        System.out.println("move " + n + " from right to mid");
        leftToMid(n - 1);
    }

    private static void rightToLeft(int n) {
        if (n == 1){
            System.out.println("move 1 from right to left");
            return;
        }
        rightToMid(n - 1);
        System.out.println("move " + n + " from right to left");
        midToLeft(n - 1);
    }

    private static void midToLeft(int n) {
        if (n == 1){
            System.out.println("move 1 from mid to left");
            return;
        }
        midToRight(n - 1);
        System.out.println("move " + n + " from mid to left");
        rightToLeft(n - 1);
    }

    public static void hanoi2(int n){
        fromToDect("left", "mid", "right", n);
    }

    private static void fromToDect(String from, String other, String to, int n) {
        if (n == 1){
            System.out.println("move 1 from " + from + " to " + to);
            return;
        }
        fromToDect(from, to, other, n - 1);
        System.out.println("move " + n + " from " + from + " to " + to);
        fromToDect(other, from, to, n - 1);

    }

    public static void main(String[] args) {
        hanoi1(3);
        System.out.println("=================");
        hanoi2(3);
    }
}
