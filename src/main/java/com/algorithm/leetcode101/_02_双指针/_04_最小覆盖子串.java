package com.algorithm.leetcode101._02_双指针;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.cn/problems/minimum-window-substring/
 * @Author: xiehongyu
 * @Date: 2022/05/10 13:16
 */
public class _04_最小覆盖子串 {
    public String minWindow(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (char tChar : tChars) {
            tMap.put(tChar, tMap.getOrDefault(tChar, 0).intValue() + 1);
        }
        int l = 0;
        int r = 0;
        boolean enough = false;
        int minLen = Integer.MAX_VALUE;
        String res = "";
        while (r < s.length()) {
            sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r), 0).intValue() + 1);
            Iterator<Character> iterator = tMap.keySet().iterator();
            boolean flag = false;

            while (iterator.hasNext()) {
                Character next = iterator.next();
                if (sMap.getOrDefault(next, 0).intValue() < tMap.get(next).intValue()) {
                    r++;
                    flag = true;
                    break;
                }
            }
            if (flag) continue;
            enough = true;
            r++;
            minLen = r - l;
            res = s.substring(l, r);
            break;
        }

        while (r <= s.length()) {
            if (enough) {
                char c = s.charAt(l);
                sMap.put(c, sMap.get(c).intValue() - 1);
                if (tMap.containsKey(c) && sMap.get(c).intValue() < tMap.get(c).intValue()){
                    enough = false;
                }
                l++;
                if (enough) {
                    if (r - l <= minLen) {
                        minLen = r - l;
                        res = s.substring(l, r);
                    }
                }
            }else {
                if (r == s.length()) {
                    break;
                }
                char c = s.charAt(r);
                sMap.put(c, sMap.getOrDefault(c, 0).intValue() + 1);
                if (tMap.containsKey(c) && sMap.get(c).intValue() == tMap.get(c).intValue()) {
                    enough = true;
                }
                r++;
            }
        }
        return res;
    }

    @Test
    public void test() {
//        System.out.println(minWindow("a", "a"));
//        System.out.println(minWindow("a", "aa"));
//        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
//        System.out.println(minWindow("bba", "ab"));
        System.out.println(minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
    }

    @Test
    public void test1() {
        Map<Character, Integer> map = new HashMap<>();

        String str = "abcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefgh";
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        System.out.println(JSON.toJSONString(map));
    }
}
