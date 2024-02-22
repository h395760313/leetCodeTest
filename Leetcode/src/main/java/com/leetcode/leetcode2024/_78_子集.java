package com.leetcode.leetcode2024;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/** TODO
 * https://leetcode-cn.com/problems/subsets/
 * @Author: xiehongyu
 * @Date: 2024/2/22 20:46
 */
public class _78_子集 {

    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            res.add(list);
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(subsets1(new int[]{1,2,3})));
    }
}
