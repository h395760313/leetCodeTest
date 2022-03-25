package com.algorithm.huawei.春招冲刺攻略2021.Ⅰ.数组与字符串;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiehongyu
 * @date 2022-03-17
 */
public class _15_三数之和 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2) {
            int x = i + 1;
            int y = nums.length - 1;
            while (x < y) {
                int sum = nums[i] + nums[x] + nums[y];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[x], nums[y]));
                    while (x < y && nums[x + 1] == nums[x]) x++;
                    while (x < y && nums[y - 1] == nums[y]) y--;
                    x++;
                    y--;
                }else if (sum < 0) x++;
                else y--;
            }
            while (i < nums.length - 2 && nums[i + 1] == nums[i]) i++;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(threeSum(new int[]{-1,0,1,2,-1,-4})));
    }

}
