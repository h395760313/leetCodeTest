package com.algorithm.structure.算法.动态规划;

/**
 * @Description todo
 * @Author: x
 */
public class 硬币问题2 {


    public static int ways1(int[] arr, int aim){
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }

    private static int process1(int[] arr, int index, int rest){
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int count = 0; count * arr[index] <= rest; count++) {
            ways += process1(arr, index + 1, rest - count * arr[index]);
        }
        return ways;
    }

    public static int ways2(int[] arr, int aim){
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length+1][aim+1];
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
        for (int count = 0; count * arr[index] <= rest; count++) {
            ways += process2(arr, index + 1, rest - count * arr[index], dp);
        }
        dp[index][rest] = ways;
        return ways;
    }

    public static int ways3(int[] arr, int aim){
        int N = arr.length;
        if (arr == null || N == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[N +1][aim+1];
        dp[N][0] = 1;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int ways = 0;
                for (int count = 0; count * arr[index] <= rest; count++) {
                    ways += dp[index + 1][rest - count * arr[index]];
                }
                dp[index][rest] = ways;
            }
        }
        return dp[0][aim];
    }


    public static int ways4(int[] arr, int aim){
        int N = arr.length;
        if (arr == null || N == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[N +1][aim+1];
        dp[N][0] = 1;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[index][rest] = dp[index + 1][rest];
                if (rest - arr[index] >= 0) {
                    dp[index][rest] += dp[index][rest - arr[index]];
                }
            }
        }
        return dp[0][aim];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,10,50,100};
        int aim = 1000;
        System.out.println(ways1(arr, aim));
        System.out.println(ways2(arr, aim));
        System.out.println(ways3(arr, aim));
        System.out.println(ways4(arr, aim));
    }
}
