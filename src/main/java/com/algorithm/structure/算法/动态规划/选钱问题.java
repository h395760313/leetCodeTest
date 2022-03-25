package com.algorithm.structure.算法.动态规划;

/**
 * @author xiehongyu
 * @date 2022-03-23
 */
public class 选钱问题 {

    public static int ways1(int[] arr, int aim){
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }

    private static int process1(int[] arr, int index, int rest){
        if (rest < 0) {
            return 0;
        }
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }

        int ways = 0;
        for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
            ways += process1(arr, index + 1, rest - zhang * arr[index]);
        }
        return ways;
    }

    public static int ways2(int[] arr, int aim){
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length + 1][aim+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return process2(arr, 0, aim, dp);
    }

    private static int process2(int[] arr, int index, int rest, int[][] dp){
        if (dp[index][rest] != -1) {
            return dp[index][rest];
        }
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
            ways += process2(arr, index + 1, rest - zhang * arr[index], dp);
        }
        dp[index][rest] = ways;
        return ways;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{5,10,50,100};
        int aim = 1000;
        System.out.println(ways1(arr, aim));
        System.out.println(ways2(arr, aim));
    }
}
