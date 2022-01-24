package com.leetCode._18_四数之和;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author xiehongyu
 * @date 2022/1/21 17:47
 */
public class _18_四数之和_template {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {

            for (int j = i + 1; j < nums.length - 2; j++) {
                int x = j + 1;
                int y = nums.length - 1;
                while (x < y) {
                    int sum = nums[i] + nums[j] + nums[x] + nums[y];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[x], nums[y]));
                        while (x < y && nums[x] == nums[x + 1]) x++;
                        while (x < y && nums[y] == nums[y - 1]) y--;
                        x++;y--;
                    }else if (sum < target) {
                        x++;
                    }else {
                        y--;
                    }
                }
                while (j < nums.length - 2 && nums[j] == nums[j + 1]) j++;
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }


    @Test
    public void test() {
        System.out.println(JSON.toJSONString(fourSum(new int[]{1,2,2,2,2,2,3}, 8)));
    }
}
