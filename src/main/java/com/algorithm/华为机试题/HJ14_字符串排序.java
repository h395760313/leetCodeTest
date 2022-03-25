package com.algorithm.华为机试题;


import java.util.*;

/**
 * https://www.nowcoder.com/ta/huawei
 * 描述
 * 给定 n 个字符串，请对 n 个字符串按照字典序排列。
 *
 * 数据范围： 1 \le n \le 1000 \1≤n≤1000  ，字符串长度满足 1 \le len \le 100 \1≤len≤100
 * 输入描述：
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 输出描述：
 * 数据输出n行，输出结果为按照字典序排列的字符串。
 * 示例1
 *
 * 输入：
 * 9
 * cap
 * to
 * cat
 * card
 * two
 * too
 * up
 * boat
 * boot
 *
 * 输出：
 * boat
 * boot
 * cap
 * card
 * cat
 * to
 * too
 * two
 * up
 */
public class HJ14_字符串排序 {
    /**
     * arrays.sort();
     */
    public static void sort1() {
        Scanner in = new Scanner(System.in);

        int count = in.nextInt();
        String[] arr = new String[count];
        for (int i = 0; i < count; i++) {
            arr[i] = in.next();
        }
        Arrays.sort(arr);

        for (int i = 0; i < count; i++) {
            System.out.println(arr[i]);
        }
    }


    /**
     * PriorityQueue 优先级队列
     */
    public static void sort2() {
        Scanner in = new Scanner(System.in);

        int count = in.nextInt();
        PriorityQueue<String> queue = new PriorityQueue<>();
        for (int i = 0; i < count; i++) {
            queue.offer(in.next());
        }

        for (int i = 0; i < count; i++) {
            System.out.println(queue.poll());
        }
    }

    /**
     * list.sort();
     */
    public static void sort3() {
        Scanner in = new Scanner(System.in);

        int count = in.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(in.next());
        }

        list.sort((o1, o2) -> {
            int i = 0;
            while (i < o1.length() && i < o2.length()) {
                if (o1.charAt(i) == o2.charAt(i)){
                    i++;
                    continue;
                }

                return o1.charAt(i) - o2.charAt(i);
            }
            if (o1.length() <= o2.length()) return -1;
            else return 1;
        });

        for (int i = 0; i < count; i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * list.sort();
     */
    public static void sort4() {
        Scanner in = new Scanner(System.in);

        int count = in.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(in.next());
        }


    }

    public static void main(String[] args) {
        sort3();
    }
}
