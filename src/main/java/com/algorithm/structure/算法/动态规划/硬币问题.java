package com.algorithm.structure.算法.动态规划;

/**
 * @Description todo
 * @Author: x
 */
public class 硬币问题 {


    public static int ways1(int[] arr, int aim){
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }

    private static int process1(int[] arr, int i, int rest){
        if (i == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int count = 0; count * arr[i] <= rest; count++) {
            ways += process1(arr, i + 1, rest - count * arr[i]);
        }
        return ways;
    }

    public static int ways2(int[] arr, int aim){
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length + 1][aim + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return process2(arr, 0, aim, dp);
    }

    private static int process2(int[] arr, int i, int rest, int[][] dp){
        if (dp[i][rest] != -1) {
            return dp[i][rest];
        }
        if (i == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int count = 0; count * arr[i] <= rest; count++) {
            ways += process2(arr, i + 1, rest - count * arr[i], dp);
        }
        dp[i][rest] = ways;
        return ways;
    }

    public static int ways3(int[] arr, int aim){
        int N = arr.length;
        if (arr == null || N == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;
        for (int i = N - 1; i >= 0; i--) {
            for (int rest = 0; rest <= aim; rest++) {
                for (int count = 0; count * arr[i] <= rest; count++) {
                    dp[i][rest]+= dp[i + 1][rest - count * arr[i]];
                }
            }
        }
        return dp[0][aim];
    }

    public static int ways4(int[] arr, int aim){
        int N = arr.length;
        if (arr == null || N == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;
        for (int i = N - 1; i >= 0; i--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[i][rest] = dp[i + 1][rest];
                if (rest - arr[i] >= 0) {
                    dp[i][rest] += dp[i][rest - arr[i]];
                }
            }
        }
        return dp[0][aim];
    }

    public static void main(String[] args) {
        int[] ints = {5, 10, 50, 100};
        int aim = 1000;
        System.out.println(ways1(ints, aim));
        System.out.println(ways2(ints, aim));
        System.out.println(ways3(ints, aim));
        System.out.println(ways4(ints, aim));
    }
}
