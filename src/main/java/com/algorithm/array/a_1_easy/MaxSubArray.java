package com.algorithm.array.a_1_easy;

/*给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

 示例:

 输入: [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。


 进阶:

 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 Related Topics 数组 分治算法 动态规划
 👍 2577 👎 0*/
public class MaxSubArray {

    /**
     * 时间复杂度为n^2
     *
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int newMax = 0;
            for (int j = i; j < nums.length; j++) {
                newMax += nums[j];
                if (newMax > max) {
                    max = newMax;
                }
            }
        }
        return max;
    }

    /**
     * 时间复杂度为 n
     *
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(sum, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

//        System.out.println(maxSubArray1(arr));
        System.out.println(maxSubArray2(arr));
    }
}


/*
    这道题用动态规划的思路并不难解决，比较难的是后文提出的用分治法求解，但由于其不是最优解法，所以先不列出来
    动态规划的是首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 ans
    如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
    如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
    每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果
    时间复杂度：O(n)
*/
