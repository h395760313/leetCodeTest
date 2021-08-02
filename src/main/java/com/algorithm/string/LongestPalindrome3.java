package com.algorithm.string;

//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1：
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//
//
// 示例 2：
//
// 输入: "cbbd"
//输出: "bb"
//
// Related Topics 字符串 动态规划

/**
 *
 */

public class LongestPalindrome3 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String babadab = longestPalindrome("ac");
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(babadab);
    }


    public static String longestPalindrome(String s) {

        int len = s.length();
        if (len < 2) {
            return s;
        }

        String str = addBoundAries(s, '#');
        System.out.println(str);
        int sLen = str.length();

        int maxLen = 1;

        int start = 0;

        for (int i = 0; i < sLen; i++) {
            int curLen = valid(str, i);
            if (curLen > maxLen) {
                maxLen = curLen;
                start = (i - curLen) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }

    private static int valid(String s, int center) {
        int len = s.length();
        int i = center - 1;
        int j = center + 1;
        int step = 0;
        while (i >= 0 && j < len && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            step++;
        }
        return step;
    }

    /***
     * 创建预处理字符串
     * @param s 原始字符串
     * @param divide 分隔字符
     * @return 使用分隔字符处理以后得到的字符串
     */
    private static String addBoundAries(String s, char divide) {
        int len = s.length();
        if (len == 0) {
            return "";
        }
        if (s.indexOf(divide) != -1) {
            throw new IllegalArgumentException("参数错误，输入的分隔符在字符串中存在");
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(divide);
            sb.append(s.charAt(i));
        }
        sb.append(divide);
        return sb.toString();
    }
}
