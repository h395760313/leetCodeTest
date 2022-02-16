package com.algorithm.leetCode._4_寻找两个正序数组的中位数;


import com.alibaba.fastjson.JSON;
import org.junit.Test;


/**
 *
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class _4_220124 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = 0;
        int y = 0;
        int len = nums1.length + nums2.length;
        int[] res = new int[len];
        int index = 0;
        while(x < nums1.length || y < nums2.length) {
            if(x >= nums1.length || (y < nums2.length && nums1[x] >= nums2[y])) {
                res[index++] = nums2[y++];
            }else{
                res[index++] = nums1[x++];
            }
        }
        if (res.length == 1) return res[0];
        if((len & 1) == 0) {
            return ((double)res[(len >> 1) - 1] + (double)res[len >> 1]) / 2;
        }else{
            return res[len >> 1];
        }
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(findMedianSortedArrays(new int[]{},new int[]{2, 3})));
    }
}
