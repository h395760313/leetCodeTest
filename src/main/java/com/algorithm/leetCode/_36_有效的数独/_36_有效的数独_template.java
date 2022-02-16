package com.algorithm.leetCode._36_有效的数独;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://leetcode-cn.com/problems/valid-sudoku/
 * @author xiehongyu
 * @date 2022/01/06 17:12
 */
public class _36_有效的数独_template {

    public boolean isValidSudoku1(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            Set<Character> latSet = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                // 校验每行
                if (board[i][j] != '.'){
                    if (rowSet.contains(board[i][j])) {
                        return false;
                    }
                    rowSet.add(board[i][j]);
                }
                // 校验每列
                if (board[j][i] != '.'){
                    if (colSet.contains(board[j][i])) {
                        return false;
                    }
                    colSet.add(board[j][i]);
                }
                // 校验每个九宫格
                int row = (j / 3) + ((i / 3) * 3);
                int col = (j % 3) + ((i % 3) * 3);

                if (board[row][col] != '.'){
                    if (latSet.contains(board[row][col])) {
                        return false;
                    }
                    latSet.add(board[row][col]);
                }
            }
        }
        return true;
    }


    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < board.length; i++) {

            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            Set<Character> latSet = new HashSet<>(); // lattice
            for (int j = 0; j < board[i].length; j++) {
                // 判断此行是否存在这个元素
                if (board[i][j] != '.' && rowSet.contains(board[i][j])) {
                    return false;
                }
                // 判断此列是否存在这个元素
                if (board[j][i] != '.' && colSet.contains(board[j][i])) {
                    return false;
                }


                // 判断此此九宫格是否存在此元素
                int latRow = (i / 3) * 3 + (j / 3);
                int latCol = (i % 3) * 3 + (j % 3);
                if (board[latRow][latCol] != '.' && latSet.contains(board[latRow][latCol])) {
                    return false;
                }
                rowSet.add(board[i][j]);
                colSet.add(board[j][i]);
                latSet.add(board[latRow][latCol]);
            }
        }
        return true;
    }

    //  0,0     0,1     0,2     0,3     0,4     0,5     0,6     0,7     0,8
    //  1,0     1,1     1,2     1,3     1,4     1,5     1,6     1,7     1,8
    //  2,0     2,1     2,2     2,3     2,4     2,5     2,6     2,7     2,8
    //  3,0     3,1     3,2     3,3     3,4     3,5     3,6     3,7     3,8
    //  4,0     4,1     4,2     4,3     4,4     4,5     4,6     4,7     4,8
    //  5,0     5,1     5,2     5,3     5,4     5,5     5,6     5,7     5,8
    //  6,0     6,1     6,2     6,3     6,4     6,5     6,6     6,7     6,8
    //  7,0     7,1     7,2     7,3     7,4     7,5     7,6     7,7     7,8
    //  8,0     8,1     8,2     8,3     8,4     8,5     8,6     8,7     8,8




    @Test
    public void test() {
        System.out.println(JSON.toJSONString(isValidSudoku(new char[][]{
                 {'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}
        })));
    }
}
