package com.leetCode._51_N皇后;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/n-queens/
 * @author xiehongyu
 * @date 2022/1/20 15:06
 */
public class _51_N皇后_template {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList<>();
        int[] queens = new int[n]; // 行集合
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<>(); // 列集合
        Set<Integer> xies1 = new HashSet<>(); // 斜线集合1
        Set<Integer> xies2 = new HashSet<>(); // 斜线集合2
        backtract(res, queens, n, 0, columns, xies1, xies2);
        return res;
    }

    private void backtract(List<List<String>> res, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> xies1, Set<Integer> xies2) {
        if (row == n) {
            // 说明每行都正确放置了一个皇后，添加一个正确解
            List<String> board = generateBoard(queens, n);
            res.add(board);
        }else {
            for (int i = 0; i < n; i++) {
                // 判断此列是否已放置皇后
                if (columns.contains(i)) {
                    continue;
                }
                // 找到规律左上到右下斜线的坐标之差相同
                int xie1 = row - i;
                if (xies1.contains(xie1)) {
                    continue;
                }
                // 找到规律左下到右上斜线的坐标之和相同
                int xie2 = row + i;
                if (xies2.contains(xie2)) {

                    continue;
                }

                // 进入到这里说明此位置允许放置皇后
                queens[row] = i;
                columns.add(i);
                xies1.add(xie1);
                xies2.add(xie2);
                backtract(res, queens, n, row + 1, columns, xies1, xies2);
                queens[row] = -1;
                columns.remove(i);
                xies1.remove(xie1);
                xies2.remove(xie2);
            }
        }
    }

    private List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }


    @Test
    public void test() {
        for (List<String> list : solveNQueens(4)) {
            System.out.println(JSON.toJSONString(list));
        }
    }
}
