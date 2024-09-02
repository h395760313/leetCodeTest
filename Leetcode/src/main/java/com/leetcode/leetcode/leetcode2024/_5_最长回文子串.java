package com.leetcode.leetcode.leetcode2024;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class _5_最长回文子串 {

    public String longestPalindrome(String s) {
        String str = fillStr(s, "#");
        int max = 0;
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            int l = i - 1;
            int r = i + 1;
            while (l >= 0 && r < str.length() && str.charAt(l) == str.charAt(r)) {
                l--;
                r++;
            }
            if (r - l > max) {
                max = r - l;
                res = s.substring((l + 1) / 2, r / 2);
            }
        }
        return res;
    }

    private String fillStr(String s, String s1) {
        StringBuilder sb = new StringBuilder();
        sb.append(s1);
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i))
                    .append(s1);
        }
        return sb.toString();
    }


    @Test
    public void test() {
        System.out.println(JSON.toJSONString(longestPalindrome("cbbd")));
    }
}
