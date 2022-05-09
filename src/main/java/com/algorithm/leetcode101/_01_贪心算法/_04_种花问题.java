package com.algorithm.leetcode101._01_贪心算法;

import com.sun.org.apache.bcel.internal.generic.IFGE;
import org.junit.Test;

/**
 * https://leetcode.cn/problems/can-place-flowers/
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给你一个整数数组flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数n ，能否在不打破种植规则的情况下种入n朵花？能则返回 true ，不能则返回 false。
 * @Author: xiehongyu
 * @Date: 2022/05/09 16:35
 */
public class _04_种花问题 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if (n == 0) return true;
        if (len < n) {
            return false;
        }
        if (len == 1) {
            if (n == 1 && flowerbed[0] == 0) {
                return true;
            } else {
                return false;
            }
        }
        int count = 0;
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            count++;
        }

        for (int i = 1; i < len - 1; i++) {
            if (flowerbed[i] == 1) {
                i++;
                continue;
            }
            if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                count++;
            }

        }

        if (flowerbed[len - 1] == 0 && flowerbed[len - 2] == 0) {
            flowerbed[len - 1] = 1;
            count++;
        }

        return count >= n;
    }

    @Test
    public void test() {
        System.out.println(canPlaceFlowers(new int[]{1}, 0));
    }
}
