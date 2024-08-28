package com.leetcode.leftgod.recursion;

import org.junit.Test;

/**
 * 背包问题
 *
 * @Author: xiehongyu
 * @Date: 2024/03/26 15:45
 */
public class Knapsack {

    public int bag(int[] weights, int[] values, int bag) {
        return process(weights, values, 0, 0, bag, 0);
    }

    private int process(int[] weights, int[] values, int alreadyWeight, int alreadyValue, int bag, int i) {
        if (alreadyWeight > bag) {
            return 0;
        }
        if (i == weights.length) {
            return alreadyValue;
        }
        return Math.max(process(weights, values, alreadyWeight + weights[i], alreadyValue + values[i], bag, i + 1),
                process(weights, values, alreadyWeight, alreadyValue, bag, i + 1));
    }

    @Test
    public void test() {
        System.out.println(bag(new int[]{1, 2, 3, 4}, new int[]{2, 2, 3, 6}, 7));
    }
}
