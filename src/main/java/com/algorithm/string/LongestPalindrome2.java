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
 * 暴力法采用双指针两边夹，验证是否是回文子串，时间复杂度比较高，除了枚举字符串的左右边界以外，比较容易想到的是枚举可能出现的回文子串的“中心位置”，从“中心位置”尝试尽可能扩散出去，得到一个回文串。
 *
 * 因此，中心扩散法的思路是：遍历每一个索引，以这个索引为中心，利用“回文串”中心对称的特点，往两边扩散，看最多能扩散多远。
 *
 * 枚举“中心位置”时间复杂度为 ，从“中心位置”扩散得到“回文子串”的时间复杂度为 ，因此时间复杂度可以降到 。
 *
 * 在这里要注意一个细节：回文串在长度为奇数和偶数的时候，“回文中心”的形式是不一样的。
 *
 * 奇数回文串的“中心”是一个具体的字符，例如：回文串 "aba" 的中心是字符 "a"；
 * 偶数回文串的“中心”是位于中间的两个字符的“空隙”，例如：回文串串 "abba" 的中心是两个 "b" 中间的那个“空隙”。
 * 图 1 ：奇数回文串与偶数回文串
 * 我们看一下一个字符串可能的回文子串的中心在哪里？
 *
 * 图 2：枚举可能的所有回文中心
 * 我们可以设计一个方法，兼容以上两种情况：
 *
 * 1、如果传入重合的索引编码，进行中心扩散，此时得到的回文子串的长度是奇数；
 *
 * 2、如果传入相邻的索引编码，进行中心扩散，此时得到的回文子串的长度是偶数。
 *
 * 具体编码细节在以下的代码的注释中体现。
 */

public class LongestPalindrome2 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        String babadab = longestPalindrome2("babadabgsdjkkkjljjhjkklljlhllkhklkjhjklkjljkhjhklkjlkjhhkjljlkhkhlklkieghseghshjsggsdhsdfhsrhgsdfgsdgshsshbabadabgsdfgkjjmnjkggnoijgsiuhgnsieghseghshjsggsdhsdfhsrhgsdfgsdgshsshbabadabgsdfgkjjmnjkggnoijgsiuhgnsieghseghshjsggsdhsdfhsrhgsdfgsdgshsshbabadabgsdfgkjjmnjkggnoijgsiuhgnsieghseghshjsggsdhsdfhsrhgsdfgsdgshsshbabadabgsdfgkjjmnjkggnoijgsiuhgnsieghseghshjsggsdhsdfhsrhgsdfgsdgshsshbabadabgsdfgkjjmnjkggnoijgsiuhgnsieghseghshjsggsdhsdfhsrhgsdfgsdgshsshbabadabgsdfgkjjmnjkggnoijgsiuhgnsieghseghshjsggsdhsdfhsrhgsdfgsdgshsshbabadabgsdfgkjjmnjkggnoijgsiuhgnsieghseghshjsggsdhsdfhsrhgsdfgsdgshsshbabadabgsdfgkjjmnjkggnoijgsiuhgnsieghseghshjsggsdhsdfhsrhgsdfgsdgshsshbabadabgsdfgkjjmnjkggnoijgsiuhgnsieghseghshjsggsdhsdfhsrhgsdfgsdgshsshbabadabgsdfgkjjmnjkggnoijgsiuhgnsieghseghshjsggsdhsdfhsrhgsdfgsdgshssh");
        String babadab = longestPalindrome2("baeaeac");
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(babadab);

    }

    public static String longestPalindrome2(String s) {
        int len = s.length();

        int maxL = 0;
        return null;
    }


















    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        String res = s.substring(0, 1);

        // 中心位置到len - 2 即可
        for (int i = 0; i < len - 1; i++) {
            String oddStr = valid(s, i, i);
            String evenStr = valid(s, i, i + 1);
            String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (maxLenStr.length() > maxLen) {
                maxLen = maxLenStr.length();
                res = maxLenStr;
            }
        }
        return res;
    }

    private static String valid(String s, int left, int right) {
        // left = right 的时候，此时回文中心是一个空隙，回文串的长度是奇数
        // left = right + 1 的时候，此时回文中心是任意一个字符，回文串的长度是偶数
        int len = s.length();
        while (left >= 0 && right < len) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else break;
        }
        // 这是要小心，跳出while循环时，恰好满足 s.charAt(i) != s.charAt(j)，因此不能取i，不能取j
        return s.substring(left + 1, right);
    }
}
