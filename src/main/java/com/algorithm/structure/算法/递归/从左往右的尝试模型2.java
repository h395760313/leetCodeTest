package com.algorithm.structure.算法.递归;


import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 背包问题
 * @author xiehongyu
 * @date 2022-03-20
 */
public class 从左往右的尝试模型2 {

    /**
     * @param w 重量数组
     * @param v 价值数字
     * @param bag 背包容量
     * @return
     */
    public static int getMaxValue(int[] w, int[] v, int bag){
        if (w == null || v == null || w.length == 0 || v.length == 0 || bag <= 0) return 0;
        return process2(w, v, 0,bag);
    }


    public static int process1(int[] w, int[] v, int index, int alreadyW, int bag){
        if (alreadyW > bag) {
            return -1;
        }
        if (index == w.length) {
            return 0;
        }
        int p1 = process1(w, v, index + 1, alreadyW, bag);
        int p2Next = process1(w, v, index + 1, alreadyW + w[index], bag);
        int p2 = -1;
        if (p2Next != -1) {
            p2 = v[index] + p2Next;
        }
        return Math.max(p1, p2);
    }

    public static int process2(int[] w, int[] v, int index, int rest){
        if (rest < 0) {
            return -1;
        }
        if (index == w.length) {
            return 0;
        }
        int p1 = process2(w, v, index + 1, rest);
        int p2Next = process2(w, v, index + 1, rest - w[index]);
        int p2 = -1;
        if (p2Next != -1) {
            p2 = v[index] + p2Next;
        }
        return Math.max(p1, p2);
    }

    public static int dpway(int[] w, int[] v, int bag){
        int N = w.length;
        int[][] dp = new int[N+1][bag+1];
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= bag; rest++) {
                int p1 = dp[index+1][rest];
                int p2 = -1;
                if (rest - w[index] >= 0) {
                    p2 = v[index] + dp[index + 1][rest - w[index]];
                }
                dp[index][rest] = Math.max(p1, p2);
            }
        }
        return dp[0][bag];
    }

    public static void main(String[] args) {
        int[] w = new int[]{3,3,6,5,4,1,2};
        int[] v = new int[]{1,4,3,5,3,4,3};
        int bag = 15;
        System.out.println(getMaxValue(w, v, bag));
        System.out.println(dpway(w, v, bag));
    }
}
