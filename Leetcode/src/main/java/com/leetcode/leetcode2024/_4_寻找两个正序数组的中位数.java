package com.leetcode.leetcode2024;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class _4_寻找两个正序数组的中位数 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int i1 = 0;
        int i2 = 0;
        int i = 0;
        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] <= nums2[i2]) {
                arr[i++] = nums1[i1++];
            } else {
                arr[i++] = nums2[i2++];
            }
        }
        while (i1 < nums1.length) {
            arr[i++] = nums1[i1++];
        }
        while (i2 < nums2.length) {
            arr[i++] = nums2[i2++];
        }
        if (arr.length % 2 == 0) {
            return arr[arr.length / 2] / 2.0 + arr[arr.length / 2 - 1] / 2.0;
        }
        return arr[arr.length / 2];
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4})));
    }
}
