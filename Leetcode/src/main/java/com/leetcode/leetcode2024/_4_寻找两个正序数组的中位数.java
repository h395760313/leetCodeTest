package com.leetcode.leetcode2024;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class _4_寻找两个正序数组的中位数 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] nums = new int[len];
        int i = 0;
        int j = 0;
        int index = 0;
        while (index < len && i < nums1.length && j < nums2.length) {
            nums[index++] = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
        }
        while (index < len) {
            nums[index++] = i < nums1.length ? nums1[i++] : nums2[j++];
        }
        if (len % 2 == 0) {
            return  (nums[len / 2] + nums[len / 2 - 1] )/ 2.0;
        }
        return nums[len / 2];
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(findMedianSortedArrays(new int[]{1,2},new int[]{3,4})));
    }
}
