package com.algorithm.leetCode._88_合并两个有序数组;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 *
 * @Author: xiehongyu
 * @Date: 2023/09/01 21:35
 */
public class _88_合并两个有序数组_template {


    @Test
    public void test() {
        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        int x = 0;
        int y = 0;

        while (x < m || y < n) {
            if (nums1[x] == 0) {
                break;
            }
            if (nums1[x] > nums2[y]) {
                int temp = nums2[y];
                nums2[y] = nums1[x];
                nums1[x] = temp;
            }
            x++;
        }
        if (y < n) {
            while ( x < m + n) {
                nums1[x++] = nums2[y++];
            }
        }
    }


}
