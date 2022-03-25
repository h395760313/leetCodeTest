package com.algorithm.structure.算法.递归;

/**
 * @author xiehongyu
 * @date 2022-03-21
 */
public class N皇后问题 {
    public static int num1(int n){
        if (n < 1) return 0;
        int[] record = new int[n]; // 行 record[i] -> i行的皇后，放在了第几列
        return process1(record, n, 0);
    }

    /**
     * 潜台词：record[0...i-1]的皇后，任何两个皇后都不能同行、同列、同一斜线
     * @param record record[0...i-1]表示之前的行，放了皇后的位置
     * @param n 代表总共有多少行
     * @param row 目前来到了第row行
     * @return 摆完所有的皇后，合理的摆法有多少种
     */
    private static int process1(int[] record, int n, int row){
        if (row == n) { // base case
            return 1;
        }
        int res = 0;
        for (int col = 0; col < n; col++) { // 当前在row行，尝试row行所有的列 -> col
            // 当前row行的皇后，放在col列，是否不会和之前的(0...i-1)的皇后产生冲突
            // 如果是则认为有效
            // 如果不是则认为无效
            if (isValid(record, row, col)) {
                record[row] = col;
                res += process1(record, n, row + 1);
            }
        }
        return res;
    }

    // record[0...i-1]需要看，record[i...]不需要看
    // 返回row行、col列放皇后是否有效;
    private static boolean isValid(int[] record, int row, int col){
        for (int i = 0; i < row; i++) { // 之前的某个i行的皇后
            if (col == record[i] || (Math.abs(record[i] - col) == Math.abs(row - i))) {
                return false;
            }
        }
        return true;
    }

    public static int num2(int n){
        if (n < 1 || n > 32) return 0;
        // 如果你是n皇后问题，limit最右n个1，其他都为0
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process2(limit, 0, 0, 0);
    }

    /**
     * @param limit 划定了问题的规模
     * @param colLim 列限制，1位置不能放皇后，0位置可以放皇后
     * @param leftDiaLim 左斜线限制，1位置不能放皇后，0位置可以放皇后
     * @param rightDiaLim 右斜线限制，1位置不能放皇后，0位置可以放皇后
      */
    private static int process2(int limit,
                                int colLim,
                                int leftDiaLim,
                                int rightDiaLim){
        if (limit == colLim) { // base case
            return 1;
        }
        // 所有可能放皇后的位置都在pos上
        // colLim | leftDiaLim | rightDiaLim ->总限制
        // ~(colLim | leftDiaLim | rightDiaLim) -> 左侧的一坨0干扰变成1，右侧的每个1可尝试放皇后
        // limit & (~(colLim | leftDiaLim | rightDiaLim)) 使用limit & 消除左侧的一坨1
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
        int mostRightOne = 0;
        int res = 0;
        while (pos != 0) {
            // 提取出pos最右的1，其他都为0
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res += process2(limit,
                    colLim | mostRightOne,
                    (leftDiaLim | mostRightOne) << 1,
                    (rightDiaLim | mostRightOne)>> 1) ;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 14;
        long start = System.currentTimeMillis();
        System.out.println(num1(n));
        System.out.println(System.currentTimeMillis() - start + "ms");
        start = System.currentTimeMillis();
        System.out.println(num2(n));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }
}
