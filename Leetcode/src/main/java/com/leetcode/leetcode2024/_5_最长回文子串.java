package com.leetcode.leetcode2024;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.StringJoiner;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class _5_最长回文子串 {

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        String res = "";
        String fill = fill(s);
        int maxLength = 0;
        for (int i = 1; i < fill.length(); i++) {
            int len;
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < fill.length()) {
                if (fill.charAt(left) != fill.charAt(right)) {
                    break;
                }
                left--;
                right++;
            }
            len = right - left - 1;
            if (len > maxLength) {
                res = s.substring((left + 1) / 2, (right - 1) / 2);
            }
            maxLength = Math.max(maxLength, len);
        }

        return res;
    }

    private String fill(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append("#");
        }
        return sb.toString();
    }


    @Test
    public void test() {
        System.out.println(JSON.toJSONString(longestPalindrome("ab")));
    }
}
