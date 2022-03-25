package com.algorithm.structure.算法.动态规划;

import java.util.Arrays;

/**
 * @author xiehongyu
 * @date 2022-03-23
 */
public class BootWalk {


    public static int ways1(int N, int M, int K, int P){
        return walk1(N, M, K, P);
    }

    private static int walk1(int N, int cur, int rest, int P) {
        if (rest == 0) {
            return P == cur ? 1 : 0;
        }
        if (cur == 1)
            return walk1(N, 2, rest - 1, P);
        if (cur == N)
            return walk1(N, N - 1, rest - 1, P);
        return walk1(N, cur - 1, rest - 1, P) + walk1(N, cur + 1, rest - 1, P);
    }

    public static int waysCache(int N, int M, int K, int P){

        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j] = -1;
            }

        }


        int res = walkCache(N, M, K, P, dp);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                System.out.println(dp[i][j]);
            }
        }
        return res;
    }

    private static int walkCache(int N, int cur, int rest, int P, int[][] dp) {
        if (dp[cur][rest] != -1) {
            return dp[cur][rest];
        }
        if (rest == 0) {
            dp[cur][rest] = P == cur ? 1 : 0;
            return dp[cur][rest];
        }
        if (cur == 1){
            dp[cur][rest] = walkCache(N, 2, rest - 1, P, dp);
        } else if (cur == N){
            dp[cur][rest] = walkCache(N, N - 1, rest - 1, P, dp);
        } else {
            dp[cur][rest] = walkCache(N, cur - 1, rest - 1, P, dp) + walkCache(N, cur + 1, rest - 1, P, dp);
        }
        return dp[cur][rest];
    }

    public static void main(String[] args) {
        System.out.println(waysCache(7,2 ,5 ,3));
    }

}
