package com.algorithm.leetCode._16_最接近的三数之和;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/3sum/
 *
 * @author xiehongyu
 * @date 2022/1/22 10:03
 */
public class _16_最接近的三数之和_220221 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int x = i + 1, y = nums.length - 1;
            while (x < y){
                int sum = nums[i] + nums[x] + nums[y];
                if (sum == target) return sum;
                if (sum < target) {
                    while (x < y && nums[x] == nums[x + 1]) x++;
                    x++;
                }else {
                    while (x < y && nums[y] == nums[y - 1]) y--;
                    y--;
                }
                int close = Math.max(sum, target) - Math.min(sum, target);
                if (close < closest) {
                    closest = close;
                    res = sum;
                }
            }
        }
        return res;
    }


    @Test
    public void test() {
        System.out.println(JSON.toJSONString(threeSumClosest(new int[]{1, -1, 2, -4}, 1)));
    }
}
