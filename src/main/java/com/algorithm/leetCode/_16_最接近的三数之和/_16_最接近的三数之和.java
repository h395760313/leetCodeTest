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
public class _16_最接近的三数之和 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int x = i + 1;
            int y = nums.length - 1;

            while(x < y) {
                int sum = nums[i] + nums[x] + nums[y];
                if(sum == target) {
                    return sum;
                }else if(sum < target) {
                    if(min > Math.abs(sum - target)) {
                        min = Math.abs(sum - target);
                        res = sum;
                    }
                    x++;
                }else{
                    if(min > Math.abs(sum - target)) {
                        min = Math.abs(sum - target);
                        res = sum;
                    }
                    y--;
                }
            }
        }
        return res;
    }


    @Test
    public void test() {
        System.out.println(JSON.toJSONString(threeSumClosest(new int[]{1, -1, 2, -4}, 1)));
        // -1,0,0,1
    }
}
