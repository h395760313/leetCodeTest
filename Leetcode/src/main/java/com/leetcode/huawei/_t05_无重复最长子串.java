package com.leetcode.huawei;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: xiehongyu
 * @Date: 2024/06/24 15:03
 */
@Slf4j
public class _t05_无重复最长子串 {


    @Test
    public void test() {
        String s = "aaaaqwaaaaaqweaaaaaaqweraaaaaa";

        System.out.println(lengthOfLongestSubstring2(s));
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        Set<Character> set = new HashSet<>();
        int l = 0;
        int r = 1;
        set.add(s.charAt(l));

        int res = 0;
        while (r < s.length()) {
            if (!set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
                continue;
            }
            res = Math.max(res, r - l);
            set.remove(s.charAt(l++));
            set.add(s.charAt(l));
            if (l == r) {
                r++;
            }
        }
        res = Math.max(res, r - l);
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        Map<Character, Integer> map = new HashMap<>();
        int l = -1;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                l = Math.max(map.get(s.charAt(i)), l);
            }
            map.put(s.charAt(i), i);
            res = Math.max(i - l, res);
        }
        return res;
    }
}
