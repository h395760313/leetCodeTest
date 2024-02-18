package com.algorithm.leetcode101._01_贪心算法;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;

/**
 * https://leetcode.cn/problems/partition-labels/
 * @Author: xiehongyu
 * @Date: 2022/05/09 17:03
 */
public class _06_划分字母区间 {


    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> wordsCount = new HashMap<>();
        Map<Character, Integer> wordsFirst = new HashMap<>();
        Map<Character, Integer> wordsLast = new HashMap<>();
        char[] chars = s.toCharArray();
        // 统计每个字母出现的次数
        for (int i = 0; i < chars.length; i++) {
            if (wordsCount.containsKey(chars[i])) {
                wordsCount.put(chars[i], wordsCount.get(chars[i]) + 1);
                wordsLast.put(chars[i], i);
            }else {
                wordsCount.put(chars[i], 1);
                wordsFirst.put(chars[i], i);
                wordsLast.put(chars[i], i);
            }
        }
        int left = 0;
        int right = 0;
        while (left < chars.length) {
            char c = chars[left];
            right = wordsLast.getOrDefault(c, 0);
            int j = left + 1;
            while(j <= right) {
                right = Math.max(wordsLast.getOrDefault(chars[j],0), right);
                j++;
            }
            res.add(right - left + 1);
            left = j;
        }
        return res;
    }


    @Test
    public void test() {
        System.out.println(JSON.toJSONString(partitionLabels("eaaaabaaec")));
    }
}
