package com.algorithm.structure.算法.递归;

/**
 * 左右两边拿牌，获取胜者最高分数
 * @author xiehongyu
 * @date 2022-03-21
 */
public class 范围的尝试模型 {

    public static int winScore(int[] arr){
        if (arr.length < 1) return 0;
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    private static int f(int[] arr, int L, int R) {
        if (L == R) return  arr[L];
        return Math.max(arr[L] + s(arr, L + 1, R), arr[R] + s(arr, L, R - 1));
    }

    private static int s(int[] arr, int L, int R) {
        if (L == R) return 0;
        return Math.min(f(arr, L + 1, R), f(arr, L, R - 1));
    }

    public static int dpway1(int[] arr){
        int N = arr.length;
        int[][] f = new int[N][N];
        int[][] s = new int[N][N];

        for (int R = 0; R < N; R++) {
            f[R][R] = arr[R];
            for (int L = R - 1; L >= 0; L--) {
                f[L][R] = Math.max(arr[L] + s[L+1][R], arr[R] + s[L][R-1]);
                s[L][R] = Math.min(f[L+1][R], f[L][R-1]);
            }
        }
        return Math.max(f[0][N - 1], s[0][N - 1]);
    }
    public static int dpway2(int[] arr){
        int N = arr.length;
        int[][] f = new int[N][N];
        int[][] s = new int[N][N];

        for (int i = 0; i < N; i++) {
            f[i][i] = arr[i];
        }

        for (int i = 1; i < N; i++) {
            int L = 0;
            int R = i;
            while (L < N && R < N) {
                f[L][R] = Math.max(arr[L] + s[L + 1][R], arr[R] + s[L][R - 1]);
                s[L][R] = Math.min(f[L + 1][R], f[L][R - 1]);
                L++;
                R++;
            }
        }
        return Math.max(f[0][N - 1], s[0][N - 1]);
    }

    public static void main(String[] args) {

        int[] ints = {4,7,9,5,19,29,80,4};
        System.out.println(winScore(ints));
        System.out.println(dpway1(ints));
        System.out.println(dpway2(ints));
    }
}
