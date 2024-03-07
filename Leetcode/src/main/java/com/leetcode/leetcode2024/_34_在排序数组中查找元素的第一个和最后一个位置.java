package com.leetcode.leetcode2024;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * @author xiehongyu
 * @date 2024/3/7 18:33
 */
public class _34_在排序数组中查找元素的第一个和最后一个位置 {

    public int[] searchRange(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        int[] res = new int[2];
        Arrays.fill(res, -1);
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (nums[mid] == target) {
                // 从mid位置开始往前往后查第一个和最后一个
                int left = mid;
                int right = mid;
                boolean leftFlag = false;
                boolean rightFlag = false;
                while (left > 0 && nums[left] == target) {
                    left--;
                }
                while (right < nums.length - 1 && nums[right] == target) {
                    right++;
                }
                res[0] = nums[left] == target ? left : left + 1;
                res[1] = nums[right] == target ? right : right - 1;
                break;
            } else if (nums[mid] < target) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(searchRange(new int[]{2,2,2}, 2)));
    }
}
