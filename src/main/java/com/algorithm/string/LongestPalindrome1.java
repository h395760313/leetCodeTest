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
 * 根据回文子串的定义，枚举所有长度大于等于2的子串，依次判断它们是否是回文。在具体实现时，可以只针对大于“当前得到的最长回文子串长度”的子串进行“回文验证”。
 */

public class LongestPalindrome1 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String babadab = longestPalindrome("babadabgsdjkkkjljjhjkklljlhllkhklkjhjklkjljkhjhklkjlkjhhkjljlkhkhlklkieghseghshjsggsdhsdfhsrhgsdfgsdgshsshbabadabgsdfgkjjmnjkggnoijgsiuhgnsieghseghshjsggsdhsdfhsrhgsdfgsdgshsshbabadabgsdfgkjjmnjkggnoijgsiuhgnsieghseghshjsggsdhsdfhsrhgsdfgsdgshsshbabadabgsdfgkjjmnjkggnoijgsiuhgnsieghseghshjsggsdhsdfhsrhgsdfgsdgshsshbabadabgsdfgkjjmnjkggnoijgsiuhgnsieghseghshjsggsdhsdfhsrhgsdfgsdgshsshbabadabgsdfgkjjmnjkggnoijgsiuhgnsieghseghshjsggsdhsdfhsrhgsdfgsdgshsshbabadabgsdfgkjjmnjkggnoijgsiuhgnsieghseghshjsggsdhsdfhsrhgsdfgsdgshsshbabadabgsdfgkjjmnjkggnoijgsiuhgnsieghseghshjsggsdhsdfhsrhgsdfgsdgshsshbabadabgsdfgkjjmnjkggnoijgsiuhgnsieghseghshjsggsdhsdfhsrhgsdfgsdgshsshbabadabgsdfgkjjmnjkggnoijgsiuhgnsieghseghshjsggsdhsdfhsrhgsdfgsdgshsshbabadabgsdfgkjjmnjkggnoijgsiuhgnsieghseghshjsggsdhsdfhsrhgsdfgsdgshssh");
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(babadab);
    }


    public static String longestPalindrome(String s) {
        // 1. 判断字符串长度是否小于2
        int len = s.length();
        if (len < 2) {
            return s;
        }

        // 2. 设置初始最大长度为1和最长字串为第一个字符
        int maxLen = 1;
        String res = s.substring(0, 1);

        // 3. 循环遍历所有字串
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                // 判断字串是否大于最大长度、是否是回文字串
                if (j - i + 1 > maxLen && valid(s, i, j)) {
                    maxLen = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    private static boolean valid(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
