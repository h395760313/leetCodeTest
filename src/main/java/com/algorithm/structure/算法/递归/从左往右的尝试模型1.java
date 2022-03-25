package com.algorithm.structure.算法.递归;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 规定1对应A，2对应B，3对应C....
 * 那么一个数字字符串"111"就可以转换为
 * "AAA","KA","AK"
 * 给定一个只有数字字符组成的字符串str，返回有多少种转化结果
 * @author xiehongyu
 * @date 2022-03-20
 */
public class 从左往右的尝试模型1 {

    public static int transform1(String str){
        if (str.isEmpty()) return 0;
        return process1(str.toCharArray(), 0);
    }

    private static int process1(char[] str, int i){
        if (i == str.length) {
            return 1;
        }
        if (str[i] == '0') {
            return 0;
        }
        if (str[i] == '1') {
            int res = process1(str, i + 1);
            if (i < str.length - 1) {
                res += process1(str, i + 2);
            }
            return res;
        }
        if (str[i] == '2') {
            int res = process1(str, i + 1);
            if (i < str.length - 1 && str[i+1] >= '0' && str[i+1] <= '6') {
                res += process1(str, i + 2);
            }
            return res;
        }
        return process1(str, i+1);
    }

    public static int dpway(String s){
        if (s.isEmpty()) return 0;
        char[] str = s.toCharArray();
        int N = s.length();
        int[] dp = new int[N + 1];
        dp[N] = 1;
        for (int i = N - 1; i >= 0; i--) {
            if (str[i] == '1') {
                dp[i] = dp[i + 1];
                if (i < str.length - 1) {
                    dp[i] += dp[i + 2];
                }
            }else if (str[i] == '2') {
                dp[i] = dp[i + 1];
                if (i < str.length - 1 && str[i+1] >= '0' && str[i+1] <= '6') {
                    dp[i] += dp[i + 2];
                }
            }else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(transform1("21323"));

        System.out.println(dpway("21323"));
    }
}
