package com.thread.thread01;

public class Thread01 {
    static /*volatile*/ int a = 100;

    public static void main(String[] args) throws Exception {

        new Thread(() -> {
            while (a > 0) {
                System.out.println("T1--->" + --a);
            }
        }).start();
        new Thread(() -> {
            while (a > 0) {
                System.out.println("T2--->" + --a);
            }
        }).start();
        new Thread(() -> {
            while (a > 0) {
                System.out.println("T3--->" + --a);
            }
        }).start();
        new Thread(() -> {
            while (a > 0) {
                System.out.println("T4--->" + --a);
            }
        }).start();
    }
}

class T1 implements Runnable {

    public void run() {

        int a = 0;
        while (true) {
            a++;
            System.out.println(a);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (a == 10) {
                break;
            }
        }

    }
}

class T2 implements Runnable {

    public void run() {

        int a = 0;
        while (true) {
            a++;
            System.out.println(a);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (a == 10) {
                break;
            }
        }
    }
}
