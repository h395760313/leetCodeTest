package com.algorithm.leetcode101._01_贪心算法;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 *  https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
 *
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 *
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
