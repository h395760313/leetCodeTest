package com.leetcode.leetcode2024;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.cn/problems/valid-sudoku/description/
 * @author xiehongyu
 * @date 2024/3/7 19:05
 */
public class _36_有效的数独 {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> col = new HashMap<>();
        Map<Integer, Set<Character>> table = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            Set<Character> rowSet = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                // 判断行重复
                if (rowSet.contains(c)) {
                    return false;
                }
                rowSet.add(c);

                // 判断列重复
                Set<Character> set = col.getOrDefault(j, new HashSet<>());
                if (set.contains(c)) {
                    return false;
                }
                set.add(c);
                col.put(j, set);

                // 判断3X3重复
                int tableIndex = i / 3 * 3 + j / 3;
                Set<Character> tableSet = table.getOrDefault(tableIndex, new HashSet<>());
                if (tableSet.contains(c)) {
                    return false;
                }
                tableSet.add(c);
                table.put(tableIndex, tableSet);
            }
        }
        return true;
    }

    @Test
    public void test() {
        char[][] chars1 = new char[][]{
                new char[]{'5','3','.','.','7','.','.','.','.'},
                new char[]{'6','.','.','1','9','5','.','.','.'},
                new char[]{'.','9','8','.','.','.','.','6','.'},
                new char[]{'8','.','.','.','6','.','.','.','3'},
                new char[]{'4','.','.','8','.','3','.','.','1'},
                new char[]{'7','.','.','.','2','.','.','.','6'},
                new char[]{'.','6','.','.','.','.','2','8','.'},
                new char[]{'.','.','.','4','1','9','.','.','5'},
                new char[]{'.','.','.','.','8','.','.','7','9'}};
        char[][] chars2 = new char[][]{
                new char[]{'8','3','.','.','7','.','.','.','.'},
                new char[]{'6','.','.','1','9','5','.','.','.'},
                new char[]{'.','9','8','.','.','.','.','6','.'},
                new char[]{'8','.','.','.','6','.','.','.','3'},
                new char[]{'4','.','.','8','.','3','.','.','1'},
                new char[]{'7','.','.','.','2','.','.','.','6'},
                new char[]{'.','6','.','.','.','.','2','8','.'},
                new char[]{'.','.','.','4','1','9','.','.','5'},
                new char[]{'.','.','.','.','8','.','.','7','9'}};
        char[][] chars3 = new char[][]{
                new char[]{'9','3','.','.','7','.','.','.','.'},
                new char[]{'6','.','.','1','9','5','.','.','.'},
                new char[]{'.','9','8','.','.','.','.','6','.'},
                new char[]{'8','.','.','.','6','.','.','.','3'},
                new char[]{'4','.','.','8','.','3','.','.','1'},
                new char[]{'7','.','.','.','2','.','.','.','6'},
                new char[]{'.','6','.','.','.','.','2','8','.'},
                new char[]{'.','.','.','4','1','9','.','.','5'},
                new char[]{'.','.','.','.','8','.','.','7','9'}};
        char[][] chars4 = new char[][]{
                new char[]{'9','3','.','.','7','.','.','3','.'},
                new char[]{'6','.','.','1','9','5','.','.','.'},
                new char[]{'.','9','8','.','.','.','.','6','.'},
                new char[]{'8','.','.','.','6','.','.','.','3'},
                new char[]{'4','.','.','8','.','3','.','.','1'},
                new char[]{'7','.','.','.','2','.','.','.','6'},
                new char[]{'.','6','.','.','.','.','2','8','.'},
                new char[]{'.','.','.','4','1','9','.','.','5'},
                new char[]{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(chars1));
        System.out.println(isValidSudoku(chars2));
        System.out.println(isValidSudoku(chars3));
        System.out.println(isValidSudoku(chars4));
    }
}
