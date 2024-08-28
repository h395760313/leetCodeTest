package com.leetcode.leftgod.recursion;

import org.junit.Test;

/**
 * AB纸牌游戏
 *
 * @Author: xiehongyu
 * @Date: 2024/03/26 14:48
 */
public class CardInLine {


    public int cardInLine(int[] arr) {
        return Math.max(firstDP(arr, 0, arr.length - 1), secondDP(arr, 0, arr.length - 1));
    }

    private int firstDP(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        return Math.max(arr[l] + secondDP(arr, l + 1, r), arr[r] + secondDP(arr, l, r - 1));
    }

    private int secondDP(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        return Math.min(firstDP(arr, l + 1, r), firstDP(arr, l, r - 1));
    }

    @Test
    public void test() {
        System.out.println(cardInLine(new int[]{1, 100, 4}));
    }
}
