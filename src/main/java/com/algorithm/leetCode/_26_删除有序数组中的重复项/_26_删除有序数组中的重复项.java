package com.algorithm.leetCode._26_删除有序数组中的重复项;

import org.junit.Test;

/**
 * @author xiehongyu
 * @date 2022/02/22 10:22
 */
public class _26_删除有序数组中的重复项 {


    public int removeDuplicates(int[] nums) {
        int x = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            nums[x++] = nums[i];
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
        return x + 1;
    }

    @Test
    public void test() {
        System.out.println(removeDuplicates(new int[]{1,1,2}));
    }
}
