package com.algorithm.leetCode._27_移除元素;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/remove-element/
 * @author xiehongyu
 * @date 2022/02/22 11:10
 */
public class _27_移除元素 {
    public int removeElement(int[] nums, int val) {
        Arrays.sort(nums);
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < val) {
                index++;
                continue;
            }else if (nums[i] == val) {
                continue;
            }else {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    @Test
    public void test() {
        System.out.println(removeElement(new int[]{1,1,2}, 1));
    }
}
