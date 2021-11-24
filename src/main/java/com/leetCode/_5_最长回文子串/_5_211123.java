package com.leetCode._5_最长回文子串;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 *
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 * 思路：首先长度处理：当字符串长度小于2时返回自己；在字符串中拼接一个符号，
 */

public class _5_211123 {

    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        String str = joint(s);
        String res = "";
        int maxLen = 0;
        for (int i = 0; i < str.length(); i++) {
            int len = 0;
            int start = i - 1;
            int end = i + 1;
            while (start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)){
                len++;
                if (maxLen < len) {
                    maxLen = len;
                    res = s.substring(start / 2 , (end + 1) / 2);
                }
                start--;
                end++;
            }

        }
        return res;
    }

    /**
     * 拼接符号
     * @param s
     * @return
     */
    private String joint(String s){
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append('#');
        }
        return sb.toString();
    }
    @Test
    public void test() {
        System.out.println(JSON.toJSONString(longestPalindrome("ccaba")));
    }
}
