package com.leetcode.leftgod.recursion;

import org.junit.Test;

/**
 * N皇后问题
 * @Author: xiehongyu
 * @Date: 2024/03/20 18:36
 */
public class NQueens {

    /**
     * @param n n皇后 n行n列
     * @return 多少种有效的皇后摆法
     */
    public int nQueens(int n){
        int[] records = new int[n]; // records[0]表示皇后在第0行摆放的位置
        return process(0, records, n);
    }

    /**
     * 递归过程
     * @param i 当前来到了第几行
     * @param records records[0...i-1]皇后拜访的位置
     * @param n 最多多少行
     * @return 摆法数量
     */
    private int process(int i, int[] records, int n) {
        if (i == n) {
            // 如果来到了最后一行，说明前面每一行的皇后都有效地摆放好了，到最后一行只有一个位置可以摆放
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (valid(records, i, j)) {
                records[i] = j;
                res += process(i+1, records,n);
            }
        }
        return res;
    }

    private boolean valid(int[] records, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (records[k] == j || Math.abs(records[k] - j) == Math.abs(k - i)) {
                // 说明同列或同斜线
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(nQueens(14));
    }
}
