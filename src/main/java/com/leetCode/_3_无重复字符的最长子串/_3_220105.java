package com.leetCode._3_无重复字符的最长子串;


import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class _3_220105 {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) break;
                set.add(s.charAt(j));
            }
            System.out.println(set.size());
            maxLen = Math.max(maxLen, set.size());
        }
        return maxLen;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring(" "));
    }
}
