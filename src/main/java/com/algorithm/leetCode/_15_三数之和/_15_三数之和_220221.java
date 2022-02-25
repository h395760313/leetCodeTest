package com.algorithm.leetCode._15_三数之和;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 * @author xiehongyu
 * @date 2022/2/21 11:25
 */
public class _15_三数之和_220221 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;

        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2) {
            int x = i + 1;
            int y = nums.length - 1;
            while (x < y) {
                int sum = nums[i] + nums[x] + nums[y];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[x], nums[y]));
                    while (x < y && nums[x] == nums[x + 1]) x++;
                    while (x < y && nums[y] == nums[y - 1]) y--;
                    x++;
                    y--;
                }else if (sum < 0) {
                    x++;
                }else {
                    y--;
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) i++;
            i++;
        }
        return res;
    }


    @Test
    public void test() {
        System.out.println(JSON.toJSONString(threeSum(new int[]{-1,0,0,1})));
        // -1,0,0,1
    }
}
