package com.algorithm.leetcode101._01_贪心算法;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import sun.misc.LRUCache;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.cn/problems/non-overlapping-intervals/
 * @Author: xiehongyu
 * @Date: 2022/05/09 15:57
 */
public class _03_无重叠区间 {

    public int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;
        if (len == 0) return 0;
        int res = 0;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int right = intervals[0][1];
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] < right) {
                res++;
                right = Math.min(intervals[i][1], right);
                continue;
            }
            right = intervals[i][1];
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(eraseOverlapIntervals(new int[][]{new int[]{-52,31},new int[]{-73,-26},new int[]{82,97},new int[]{-65,-11},new int[]{-62,-49},new int[]{95,99},new int[]{58,95},new int[]{-31,49},new int[]{66,98},new int[]{-63,2},new int[]{30,47},new int[]{-40,-26}}));
    }
}
