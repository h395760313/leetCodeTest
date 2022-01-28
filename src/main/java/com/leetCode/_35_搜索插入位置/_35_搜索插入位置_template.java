package com.leetCode._35_搜索插入位置;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 *
 * https://leetcode-cn.com/problems/search-insert-position/
 * @author xiehongyu
 * @date 2022/01/06 17:12
 */
public class _35_搜索插入位置_template {

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target > nums[i]) {
                continue;
            }else {
                return i;
            }
        }
        return nums.length;
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(searchInsert(new int[]{1,3,5,6},8)));
    }
}
