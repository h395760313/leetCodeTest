package com.algorithm.huawei.春招冲刺攻略2021.概述;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _56_合并区间 {

    public static int[][] merge1(int[][] intervals) {
        if (intervals.length < 1) return new int[][]{};
        Arrays.sort(intervals, (Comparator.comparingInt(o -> o[0])));
        List<int[]> res = new ArrayList<>(intervals.length);
        int l = intervals[0][0];
        int r = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (r >= intervals[i][0]) {
                r = Math.max(r, intervals[i][1]);
            }else {
                res.add(new int[]{l, r});
                l = intervals[i][0];
                r = intervals[i][1];
            }
        }
        res.add(new int[]{l, r});
        return res.toArray(new int[1][]);
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length < 1) return new int[][]{};
        Arrays.sort(intervals, (Comparator.comparingInt(o -> o[0])));
        List<int[]> res = new ArrayList<>(intervals.length);
        int l = 0;
        int r = 1;
        while (l < intervals.length && r < intervals.length) {
            if (intervals[l][1] >= intervals[r][0]) {
                // 左边结尾大于右边开头，可以合并
                intervals[l][1] = Math.max(intervals[l][1], intervals[r][1]);
                r++;
            }else {
                // 没有重合部分
                res.add(intervals[l]);
                l = r++;
            }
        }
        res.add(intervals[l]);
        return res.toArray(new int[1][]);
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(merge(new int[][]{
                {2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}
        })));
    }
}
