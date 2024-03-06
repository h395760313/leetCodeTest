package com.leetcode.leetcode2024;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/
 * @Author: xiehongyu
 * @Date: 2024/03/06 23:09
 */
public class _33_搜索旋转排序数组 {

    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        if (target > nums[0]) {
            // 从0到n查询
            int index = 1;
            while (index < nums.length) {
                if (index > 0 && nums[index] < nums[index - 1]) {
                    break;
                }
                if (nums[index] == target) {
                    return index;
                }
                index++;
            }
        }else if (target < nums[0]){
            // 从n到0查询
            int index = nums.length - 1;
            while (index > 0) {
                if (index < nums.length - 1 && nums[index] > nums[index + 1]) {
                    break;
                }
                if (nums[index] == target) {
                    return index;
                }
                index--;
            }
        }else {
            return 0;
        }
        return -1;
    }

    @Test
    public void test() {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3));
    }
}
