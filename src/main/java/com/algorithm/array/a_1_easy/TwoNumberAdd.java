package com.algorithm.array.a_1_easy;

public class TwoNumberAdd {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{0, 4, 3, 0}, 0);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }

        }
        return null;
    }
}
