package com.leetcode.leetcode2024;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/coin-change/
 *
 * @Author: xiehongyu
 * @Date: 2024/03/21 20:42
 */
public class _322_零钱兑换 {

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return process(coins, amount, new int[amount]);
    }

    private int process(int[] coins, int amount, int[] count) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (count[amount - 1] != 0) {
            return count[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = process(coins, amount - coin, count);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        count[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[amount - 1];
    }


    @Test
    public void test() {
        System.out.println(coinChange(new int[]{186, 419, 83, 408}, 6249));
        System.out.println(coinChange(new int[]{1, 2}, 3));
        System.out.println(coinChange(new int[]{1, 2, 3}, 5));
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange(new int[]{32, 27, 23, 13, 7}, 94));
        System.out.println(coinChange(new int[]{1, 2, 4}, 5));
    }
}
