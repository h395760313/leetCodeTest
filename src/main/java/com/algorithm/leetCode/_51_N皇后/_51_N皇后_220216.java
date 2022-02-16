package com.algorithm.leetCode._51_N皇后;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/n-queens/
 * @author xiehongyu
 * @date 2022/1/20 15:06
 */
public class _51_N皇后_220216 {

    public List<List<String>> solveNQueens(int n) {

        // 结果
        List<List<String>> res = new ArrayList<>();
        // 行
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        // 列
        Set<Integer> cols = new HashSet<>();
        // 斜1
        Set<Integer> xies1 = new HashSet<>();
        // 斜2
        Set<Integer> xies2 = new HashSet<>();
        backtrack(res, queens, n, 0, cols, xies1, xies2);
        return res;
    }

    private void backtrack(List<List<String>> res, int[] queens, int n, int row, Set<Integer> cols, Set<Integer> xies1, Set<Integer> xies2) {
        if (row == n) {
            // 证明前面都已经放置了皇后，加入正确解
            List<String> board = genarateBoard(queens, n);
            res.add(board);
        }else {
            for (int i = 0; i < n; i++) {
                if (cols.contains(i)) {
                    continue;
                }
                int xie1 = row - i;
                if (xies1.contains(xie1)) {
                    continue;
                }
                int xie2 = row + i;
                if (xies2.contains(xie2)) {
                    continue;
                }
                queens[row] = i;
                cols.add(i);
                xies1.add(xie1);
                xies2.add(xie2);
                backtrack(res, queens, n, row + 1, cols, xies1, xies2);
                queens[row] = -1;
                cols.remove(i);
                xies1.remove(xie1);
                xies2.remove(xie2);
            }
        }

    }

    private List<String> genarateBoard(int[] queens, int n) {
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
