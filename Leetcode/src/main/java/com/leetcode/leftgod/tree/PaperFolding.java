package com.leetcode.leftgod.tree;

import org.junit.Test;

/**
 * 纸张折痕
 *
 * @author xiehongyu
 * @date 2024/3/14 09:56
 */
public class PaperFolding {


    public void printAllFolds(int n) {
        process(1, n, true);
    }

    private void process(int i, int n, boolean b) {
        if (i > n) {
            return;
        }
        process(i + 1, n, true);
        System.out.println(b ? "凹" : "凸");
        process(i + 1, n, false);
    }


    @Test
    public void test() {
        printAllFolds(4);
    }
}
