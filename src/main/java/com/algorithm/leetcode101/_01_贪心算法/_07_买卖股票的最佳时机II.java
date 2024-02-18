package com.algorithm.leetcode101._01_贪心算法;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 * @Author: xiehongyu
 * @Date: 2022/05/09 20:54
 */
public class _07_买卖股票的最佳时机II {
    public int maxProfit(int[] prices) {
        boolean flag = false; //是否持有股
        int money = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (flag){
                // 持有股
                if (prices[i] <= prices[i + 1]) {
                    // 第二天价格大于当天，跳过
                    continue;
                }else {
                    // 第二天价格低于当天，卖出
                    money += prices[i];
                    flag = false;
                }
            }else {
                if (prices[i] >= prices[i + 1]) {
                    // 第二天价格低于当天，跳过
                    continue;
                }else {
                    // 第二天价格低于当天，卖出
                    money -= prices[i];
                    flag = true;
                }
            }
        }

        if (flag) {
            money += prices[prices.length - 1];
        }
        return money;

    }

    @Test
    public void test() {
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}
