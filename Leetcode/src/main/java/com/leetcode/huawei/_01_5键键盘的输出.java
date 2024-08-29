package com.leetcode.huawei;

import org.junit.Test;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * @Author: xiehongyu
 * @Date: 2024/06/01 15:40
 */
@Slf4j
public class _01_5键键盘的输出 {


    public static void test01() {
        System.out.println("请输入：");
        Scanner scan = new Scanner(System.in);
        String[] s = scan.nextLine().split(" ");
        StringBuilder sb = new StringBuilder();
        String copy = "";
        String select = "";
        for (int i = 0; i < s.length; i++) {
            int key = Integer.parseInt(s[i]);
            switch (key) {
                case 1:
                    if (!select.isEmpty()) {
                        sb = new StringBuilder();
                    }
                    sb.append("a");
                    select = "";
                    break;
                case 2:
                    copy = select;
                    break;
                case 3:
                    copy = select;
                    sb = new StringBuilder();
                    select = "";
                    break;
                case 4:
                    if (!select.isEmpty()) {
                        sb = new StringBuilder();
                    }
                    sb.append(copy);
                    select = "";
                    break;
                case 5:
                    select = sb.toString();
                    break;
                default:
                    break;
            }
        }

        System.out.println(sb.toString());
        System.out.println(sb.length());
    }


    public static void main(String[] args) {
        test01();
    }
}
