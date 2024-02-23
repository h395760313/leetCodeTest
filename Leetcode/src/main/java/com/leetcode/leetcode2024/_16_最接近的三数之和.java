package com.leetcode.leetcode2024;

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
        int i = 0;
        int min = Integer.MAX_VALUE;
        int res = 0;
        while (i < nums.length - 2) {
            while (i < nums.length - 2 && i > 0 && nums[i] == nums[i - 1]) {
                i++;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum  - target) < min) {
                    min = Math.abs(sum  - target);
                    res = sum;
                }
                min = Math.min(Math.abs(sum  - target), min);
                if (sum > target) {
                    k--;
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }else if (sum < target){
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                }else {
                    return sum;
                }
            }
            i++;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(threeSumClosest(new int[]{0,1,2},3)));
    }
}
