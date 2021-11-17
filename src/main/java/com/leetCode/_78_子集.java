package com.leetCode;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 */
public class _78_子集 {

    /**
     * 方法1：递归
     * - 开始假设输出子集为空
     * - 遍历数组，对于数组的每一个整数，每一步都向输出子集中所有子集添加这个整数，并生成新的子集
     * [1,2,3] =
     * [] + 1
     * [],[1] + 2
     * [],[1],[2],[1,2] + 3
     * res = [],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]
     */
    public List<List<Integer>> subsets1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        res.add(list); // 在输出结果中加入空值
        // 每次遍历往之前的数组中添加num
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> newLists = new ArrayList<>();
            for (List<Integer> re : res) {
                List<Integer> newList = new ArrayList<>(re); // 复制结果中已存在的子集
                newList.add(nums[i]); // 加入当前整数
                newLists.add(newList); // 加入输出结果
            }
            res.addAll(newLists);
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(subsets1(new int[]{1,2,3})));
    }
}
