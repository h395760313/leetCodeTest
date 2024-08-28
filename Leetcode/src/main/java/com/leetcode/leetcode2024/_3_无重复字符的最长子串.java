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
        Map<Character, Integer> map = new HashMap<>();

        int max = 0;
        char[] arr = s.toCharArray();
        int l = 0;
        int r = 0;
        while (r < arr.length) {
            while (map.containsKey(arr[r])) {
                map.remove(arr[l]);
                l++;
            }
            map.put(arr[r], r);
            r++;
            max = Math.max(max, r - l);
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        Set<Character> set = new HashSet<>();

        int max = 0;
        char[] arr = s.toCharArray();
        int l = 0;
        int r = 0;
        while (r < arr.length) {
            while (set.contains(arr[r])) {
                set.remove(arr[l]);
                l++;
            }
            set.add(arr[r]);
            r++;
            max = Math.max(max, r - l);
        }
        return max;
    }


    public int lengthOfLongestSubstring3(String s) {
        boolean[] flag = new boolean[128];
        int max = 0;
        int n = s.length();
        int l = 0;
        int r = 0;
        while (r < n) {
            int idx = s.charAt(r);
            while (flag[idx]) {
                flag[s.charAt(l)] = false;
                l++;
            }
            flag[s.charAt(r)] = true;
            r++;
            max = Math.max(max, r - l);
        }
        return max;
    }


    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring3("pwwkew"));
    }
}
