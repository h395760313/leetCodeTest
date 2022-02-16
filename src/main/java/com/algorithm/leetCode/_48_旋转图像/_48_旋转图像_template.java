package com.algorithm.leetCode._48_旋转图像;


import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class _48_旋转图像_template {

    public void rotate(int[][] matrix) {
        int length = matrix.length;
        if (length < 2) return;

        // true为从左往右或从上往下  false为从右往左或从下往上
        boolean flag = true;

        // 一维
        for (int i = 0; i < length; i++) {
            // 二维
            for (int j = 0; j < length; j++) {
//                if ()
            }
        }
    }

    @Test
    public void test() {
        rotate(new int[][]{{1, 2}, {3, 4}});
    }
}
