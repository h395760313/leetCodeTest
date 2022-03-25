package com.algorithm.leetCode._136_只出现一次的数字;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/single-number/
 */
public class _136_只出现一次的数字 {

    public int singleNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            if (!list.contains(num)) {
                list.add(num+"");
            }else {
                list.remove(num+"");
            }
        }
        return Integer.parseInt(list.get(0));
    }

    @Test
    public void test() {

        System.out.println(singleNumber(new int[]{
                4,1,2,3,5,4,3,2,4
        }));
    }
}
