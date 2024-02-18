package com.algorithm.leetcode101._01_贪心算法;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 *  https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/
 * @Author: xiehongyu
 * @Date: 2022/05/09 16:48
 */
public class _05_用最少数量的箭引爆气球 {

    public int findMinArrowShots(int[][] points) {
        int len = points.length;
        if (len <= 1) return len;
        Arrays.sort(points, Comparator.comparingInt(o->o[0]));
        int res = 1;
        int right = points[0][1];
        for (int i = 1; i < len; i++) {
            if (right >= points[i][0]) {
                right = Math.min(right, points[i][1]);
                continue;
            }
            res++;
            right = points[i][1];
        }
        return res;
    }


    @Test
    public void test() {
        System.out.println(findMinArrowShots(new int[][]{new int[]{10,16},new int[]{2,8},new int[]{1,6},new int[]{7,12}}));
    }
}
