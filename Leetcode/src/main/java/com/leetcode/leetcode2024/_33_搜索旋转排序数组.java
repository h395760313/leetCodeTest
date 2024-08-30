package com.leetcode.leetcode2024;

import org.junit.Test;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：nums = [1], target = 0
 * 输出：-1
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/
 *
 * @Author: xiehongyu
 * @Date: 2024/03/06 23:09
 */
public class _33_搜索旋转排序数组 {

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            return nums[0] == target ? 0 : 1;
        }

        // 如果第一个小于最后一个，则说明没有旋转，直接使用二分法
        if (nums[0] < nums[len - 1]) {
            return find(nums, target);
        }

        // 找到最小值index
        int l = 0;
        int r = len - 1;
        int mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] > r) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        //TODO
//        int index = 0;
//        while (index < len - 1) {
//            if (nums[index] > nums[index++ + 1]) {
//                break;
//            }
//        }
//
//        int[] arr = new int[len];
//        int i = 0;
//        int stopIndex = index;
//        while (index < len) {
//            if (nums[index] == target) {
//                return index;
//            }
//            arr[i++] = nums[index++];
//        }
//
//        for (int j = 0; j < stopIndex; j++) {
//            if (nums[j] == target) {
//                return j;
//            }
//            arr[i++] = nums[j];
//        }
//
//        System.out.println(index);
        return -1;
    }

    private int find(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
