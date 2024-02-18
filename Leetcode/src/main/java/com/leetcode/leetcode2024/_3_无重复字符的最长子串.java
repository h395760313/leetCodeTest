package com.leetcode.leetcode2024;


import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class _3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        Map<Integer, Character> map = new HashMap();
        int maxLength = 0;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsValue(c)) {
                map.put(i, c);
                maxLength = Math.max(maxLength, i + 1 - index);
            }else {
                map.remove(index);
                index++;
                i--;
            }
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        Map<Integer, Character> map = new HashMap();
        int maxLength = 0;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsValue(c)) {
                map.put(i, c);
                maxLength = Math.max(maxLength, i + 1 - index);
            }else {
                while (map.get(index) != c) {
                    map.remove(index++);
                }
                map.remove(index++);

                i--;
            }
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring3(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int maxLength = 0;
        for (int i = 0; i < s.length()-1; i++) {
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            int len = 0;
            int j = i+1;
            boolean flag = false;
            while ( j < s.length()) {
                char c = s.charAt(j);
                if (set.contains(c)) {
                    len = j - i;
                    flag = true;
                    break;
                }
                set.add(c);
                j++;
            }
            if (!flag) {
                len = j - i;
            }

            maxLength = Math.max(maxLength, len);
        }
        return maxLength;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring3("aa"));
    }
}
