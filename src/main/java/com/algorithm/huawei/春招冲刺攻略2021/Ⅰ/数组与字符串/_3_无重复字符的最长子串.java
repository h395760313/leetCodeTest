package com.algorithm.huawei.春招冲刺攻略2021.Ⅰ.数组与字符串;

import com.alibaba.fastjson.JSON;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xiehongyu
 * @date 2022-03-16
 */
public class _3_无重复字符的最长子串 {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;
        int res = 0;
        while (l < s.length() && r < s.length()) {
            if (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l++));
                continue;
            }
            set.add(s.charAt(r));
            res = Math.max(res, set.size());
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(lengthOfLongestSubstring("abcabcbb")));
    }
}
