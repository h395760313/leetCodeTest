package com.leetcode.leetcode.leetcode2024;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/3sum-closest/
 * @author xiehongyu
 * @date 2024/2/20 22:27
 */
public class _16_最接近的三数之和 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int first = 0;
        int min = Integer.MAX_VALUE;
        int res = 0;
        while (first < nums.length - 2) {
            int second = first + 1;
            int third = nums.length - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (Math.abs(sum - target) <= min) {
                    min = Math.abs(sum - target);
                    res = sum;
                }
                if (sum > target) {
                    third--;
                }else if (sum < target) {
                    second++;
                }else {
                    return sum;
                }
            }
            first++;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(threeSumClosest(new int[]{-1,2,1,-4},1)));
    }
}
