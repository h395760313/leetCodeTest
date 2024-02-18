package com.algorithm.leetcode101._02_双指针;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/valid-palindrome-ii/
 * @Author: xiehongyu
 * @Date: 2022/05/30 21:46
 */
public class _06_验证回文字符串Ⅱ {

    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        int flag = 0;
        while (i < j) {
            if (flag == 0) {
                if (s.charAt(i) != s.charAt(j)) {
                    i++;
                    flag++;
                }
            }else {
                if (s.charAt(i) != s.charAt(j)) {
                    if (flag == 1) {
                        i--;
                        j--;
                        flag++;
                    }else if (flag == 2) {
                        return false;
                    }
                }else {
                    i++;
                    j--;
                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(validPalindrome("abc"));
    }
}
