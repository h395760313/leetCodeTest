package com.algorithm.array.a_1_easy;

/*给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

 你可以假设数组中无重复元素。

 示例 1:

 输入: [1,3,5,6], 5
输出: 2


 示例 2:

 输入: [1,3,5,6], 2
输出: 1


 示例 3:

 输入: [1,3,5,6], 7
输出: 4


 示例 4:

 输入: [1,3,5,6], 0
输出: 0

 Related Topics 数组 二分查找
 👍 723 👎 0*/
public class SearchInsert {
    public static int twoSearch(int[] nums, int start, int end, int target) {

        for (int i = 0; i < nums.length; i++) {
            int mid = (start + end) / 2;
            int newStart = start;
            int newEnd = end;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[end]) {
                return end + 1;
            } else if (target < nums[start]) {
                return start;
            } else if (target < nums[mid]) {
                end = mid;
                if (newEnd == end) return end;
                return twoSearch(nums, start, end, target);
            } else if (target > nums[mid]) {
                start = mid;
                if (newStart == start) return start + 1;
                return twoSearch(nums, start, end, target);
            }
        }
        return 0;
    }

    private static int searchInsert(int[] nums, int target) {

        return twoSearch(nums, 0, (nums.length - 1), target);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7};
        int target = 0;
        System.out.println(searchInsert(arr, target));
    }
}
