package com.algorithm.leetCode._56_合并区间;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class _56_合并区间_template {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            int l = intervals[i][0];
            int r = intervals[i][1];

            while (i < intervals.length - 1 && r >= intervals[i + 1][0]) {
                i++;
                r = Math.max(intervals[i][1], r);
            }
            res.add(new int[]{l, r});
            i++;
        }
        return res.toArray(new int[0][]);
    }


    public int[][] merge1(int[][] intervals) {
        // 先对二维数组进行排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        int l = 0;
        int r = 1;
        while (l < intervals.length && r < intervals.length) {
            // 如果左边结尾大于右边开头，说明可以合并
            if (intervals[l][1] >= intervals[r][0]) {
                intervals[l][1] = Math.max(intervals[l][1], intervals[r][1]);
                r++;
            }else {
                // 不能合并
                res.add(intervals[l]);
                l = r++;
            }
        }
        res.add(intervals[l]);
        return res.toArray(new int[0][]);
    }


    @Test
    public void test() {
//        System.out.println(JSON.toJSONString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(JSON.toJSONString(merge1(new int[][]{{1, 4}, {0, 1}, {2, 3}})));
    }
}
