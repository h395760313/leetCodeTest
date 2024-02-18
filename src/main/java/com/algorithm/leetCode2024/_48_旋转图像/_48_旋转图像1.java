package com.algorithm.leetCode2024._48_旋转图像;

/**
 * 上下折+左下右上对角线折
 */
class _48_旋转图像1 {

    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int rowX = 0;
        int rowY = len - 1;
        while (rowX < rowY) {

        }
    }

    private void swap(int[][] matrix, int x1, int y1, int x2, int y2){
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }
}