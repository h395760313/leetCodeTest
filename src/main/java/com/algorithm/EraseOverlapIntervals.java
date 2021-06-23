package com.algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,100},{11,22},{1,11},{2,12}};

        int count = eraseOverlapIntervals(intervals);
        System.out.println(count);
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // 排序为 {1,2},{1,3},{2,3},{3,4}
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // 初始为cur
        int[] cur = intervals[0];
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (cur[1] > intervals[i][0]){
                res++;
                cur[1] = Math.min(cur[1] , intervals[i][1]);
            }else {
                cur = intervals[i];
            }
        }

        return res;
    }
}
