package com.algorithm.huawei.春招冲刺攻略2021.Ⅰ.数组与字符串;

import com.alibaba.fastjson.JSON;
import jdk.nashorn.internal.ir.IfNode;

/**
 * @author xiehongyu
 * @date 2022-03-16
 */
public class _415_字符串相加 {

    /**
     * 解答成功:
     * 执行耗时:10 ms,击败了6.56% 的Java用户
     * 内存消耗:41.9 MB,击败了5.06% 的Java用户
     *
     * 将字符串拼接改成StringBuilder
     * 解答成功:
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:41.3 MB,击败了35.09% 的Java用户
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings1(String num1, String num2) {
//        String res = "";
        StringBuilder sb = new StringBuilder();
        int l1 = num1.length() - 1, l2 = num2.length() - 1;
        int flag = 0;
        while (l1 >= 0 || l2 >= 0) {
            int x = l1 >= 0 ? (int)num1.charAt(l1) - 48 : 0;
            int y = l2 >= 0 ? (int)num2.charAt(l2) - 48 : 0;

            int sum = x + y + flag;
            flag = sum / 10;
//            res = sum % 10 + res;
            sb.append(sum % 10);
            l1--;l2--;
        }

        if (flag == 1) {
//            res = 1 + res;
            sb.append(1);
        }
//        return res;
        return sb.reverse().toString();
    }


    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry > 0) {
            if (i >= 0) carry += num1.charAt(i--) - 48;
            if (j >= 0) carry += num2.charAt(j--) - 48;
            sb.append(carry % 10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(addStrings("11", "123")));
    }
}
