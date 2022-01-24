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
        int left = 0;
        int right = 0;
        HashSet set = new HashSet();
        while (right < s.length()) {
            char newChar = s.charAt(right);
            if (set.contains(newChar)) {
                set.remove(s.charAt(left++));
            }else {
                set.add(newChar);
                maxLen = Math.max(maxLen, set.size());
                right++;
            }
        }
        return maxLen;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
