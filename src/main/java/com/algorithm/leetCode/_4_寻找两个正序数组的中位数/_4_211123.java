package com.algorithm.leetCode._4_寻找两个正序数组的中位数;


import com.alibaba.fastjson.JSON;
import org.junit.Test;


/**
 *
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class _4_211123 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p = 0, q = 0, i = 0, len = nums1.length + nums2.length;
        int[] arr = new int[len];
        while (p < nums1.length || q < nums2.length) {
            if (p >= nums1.length) {
                // nums1已经取完
                arr[i++] = nums2[q++];
            }else if (q >= nums2.length){
                // nums2已经取完
                arr[i++] = nums1[p++];
            }else {
                // nums1 nums2 都还有数据
                if (nums1[p] <= nums2[q]) {
                    arr[i++] = nums1[p++];
                }else {
                    arr[i++] = nums2[q++];
                }
            }
        }

        if (len % 2 == 0) {
            return (arr[len / 2] + arr[len / 2 - 1]) / 2.0;
        }else {
            return arr[len / 2];
        }
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(findMedianSortedArrays(new int[]{1,3},new int[]{2})));
    }
}
