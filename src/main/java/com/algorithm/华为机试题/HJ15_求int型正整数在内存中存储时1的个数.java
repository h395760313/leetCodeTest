package com.algorithm.华为机试题;

import com.tools.Times;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

/**
 *
 * 描述
 * 输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。
 *
 * 数据范围：保证在 32 位整型数字范围内
 * 输入描述：
 *  输入一个整数（int类型）
 *
 * 输出描述：
 *  这个数转换成2进制后，输出1的个数
 *
 * 示例1
 * 输入：
 * 5
 * 输出：
 * 2
 *
 * 示例2
 * 输入：
 * 0
 * 输出：
 * 0
 */
public class HJ15_求int型正整数在内存中存储时1的个数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 500000; i++) {
            list.add((int) Math.random() * 500000);
        }
        Times.test("自写十进制转二进制", ()->{
            for (int i = 0; i < list.size(); i++) {
                NumUtils.toBinaryString(list.get(i));

            }
        });
        Times.test("Java自带十进制转二进制", ()->{
            for (int i = 0; i < list.size(); i++) {
                Integer.toBinaryString(list.get(i));

            }
        });
        Times.test("自写十进制转十六进制", ()->{
            for (int i = 0; i < list.size(); i++) {
                NumUtils.toHexString(list.get(i));

            }
        });
        Times.test("Java自带十进制转十六进制", ()->{
            for (int i = 0; i < list.size(); i++) {
                Integer.toHexString(list.get(i));

            }
        });
        String str1 = NumUtils.toHexString(999);
        String str2 = Integer.toHexString(999);

        System.out.println(str1);
        System.out.println(str2);
//        String str = NumUtils.toBinaryString(in.nextInt());
//        int res = 0;
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == '1') res++;
//        }
//        System.out.println(res);
    }
}
