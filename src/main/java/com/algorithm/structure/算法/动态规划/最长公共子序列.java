package com.algorithm.structure.算法.动态规划;

import com.alibaba.fastjson.JSON;

/**
 * 多样本位置全对应的尝试模型
 * @Description todo
 * @Author: x
 */
public class 最长公共子序列 {

    public static int lonestCommonSubsequence(String s1, String s2){
        if (s1.isEmpty() || s2.isEmpty()) {
            return 0;
        }
        int[][] dp = new int[s1.length()][s2.length()];
        dp[0][0] = s1.charAt(0) == s2.charAt(0) ? 1 : 0;
        for (int i = 1; i < s2.length(); i++) {
            dp[0][i] = dp[0][i-1] == 1 ? 1 : s1.charAt(0) == s2.charAt(i) ? 1 : 0;
        }
        for (int i = 1; i < s1.length(); i++) {
            dp[i][0] = dp[i-1][0] == 1 ? 1 : s1.charAt(i) == s2.charAt(0) ? 1 : 0;
        }

        for (int i = 1; i < s1.length(); i++) {
            for (int j = 1; j < s2.length(); j++) {
                // (1) 既不以s1[i]结尾也不以s2[j]结尾 默认 可省略
                // dp[i][j] = dp[i-1][j-1];
                // (2) 以s1[i]结尾, 不以s2[j]结尾 或 (3)不以s1[i]结尾, 以s2[j]结尾
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                // (4) 如果s1[i]==s2[j] 且既以s1[i]结尾也以s2[j]结尾
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
                }
            }
        }
        for (int[] ints : dp) {
            System.out.println(JSON.toJSONString(ints));
        }
        return dp[s1.length()-1][s2.length()-1];
    }


    public static void main(String[] args){
        String s1 = "a1b2c3d1";
        String s2 = "1ef231gh";
        System.out.println(lonestCommonSubsequence(s1, s2));
    }
}
