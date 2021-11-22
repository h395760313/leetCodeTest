package com.leetCode._3_无重复字符的最长子串;


import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class 无重复字符的最长子串_211122 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 1) return 0;
        int start = 0, end = 0, maxLen = 0;
        Set<Character> set = new HashSet<>();
        while (start < s.length() && end < s.length()) {
            char c = s.charAt(end);
            if (!set.contains(c)){
                set.add(c);
                end++;
                maxLen = Math.max(maxLen, end - start);
            }else {
                set.remove(s.charAt(start));
                start++;
            }
         }
        return maxLen;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
