package com.leetCode;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class _3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();

        Map<Character,Integer> map = new HashMap<>();
        int maxLen = 1;
        for (int start = 0,end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)){
                start = Math.max(start,map.get(c));
            }
            maxLen = Math.max(maxLen,end - start + 1);
            map.put(c,end + 1);
        }
        return maxLen;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
