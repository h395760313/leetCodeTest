package com.leetcode.leetcode2024;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/search-insert-position/z
 * @author xiehongyu
 * @date 2024/3/7 18:53
 */
public class _35_搜索插入位置 {

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int begin = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (begin <= end) {
            mid = (begin + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] < target) {
                begin = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return nums[mid] > target ? mid : mid + 1;
    }

    @Test
    public void test() {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 0));
        System.out.println(searchInsert(new int[]{}, 7));
    }
}
