package com.algorithm.leetCode._37_解数独;

import org.junit.Test;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/sudoku-solver/
 * @author xiehongyu
 * @date 2022/1/28 10:59
 */
public class _37_解数独_template {

    private boolean[][] row = new boolean[9][9];
    private boolean[][] col = new boolean[9][9];
    private boolean[][][] lat = new boolean[3][3][9];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    // 集合中添加空白格
                    spaces.add(new int[]{i, j});
                }else {
                    int digit = board[i][j] - '0' - 1;
                    // 标识第i行、第j列、第(i/3,j/3)九宫格已经存在digit这个元素
                    row[i][digit] = col[j][digit] = lat[i / 3][j / 3][digit] = true;
                }
            }
        }
        dfs(board, 0);
        printSudoku(board);
    }

    private void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }
        int[] space = spaces.get(pos);
        int i = space[0];
        int j = space[1];
        for (int digit = 0; digit < 9 && !valid; ++digit) {
            if (!row[i][digit] && !col[j][digit] && !lat[i / 3][j / 3][digit]) {
                row[i][digit] = col[j][digit] = lat[i / 3][j / 3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1);
                dfs(board, pos + 1);
                row[i][digit] = col[j][digit] = lat[i / 3][j / 3][digit] = false;
            }
        }
    }


    private void printSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

    @Test
    public void test() {
        solveSudoku(new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        });
    }
}
