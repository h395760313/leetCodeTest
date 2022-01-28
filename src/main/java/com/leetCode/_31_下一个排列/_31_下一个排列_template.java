package com.leetCode._31_下一个排列;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/next-permutation/
 *
 * @author xiehongyu
 * @date 2022/1/24 11:21
 * <p>
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * <p>
 * 示例 2：
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * <p>
 * 示例 3：
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * <p>
 * 示例 4：
 * 输入：nums = [1]
 * 输出：[1]
 */
public class _31_下一个排列_template {
    /**
     * 算法推导
     * 如何得到这样的排列顺序？这是本文的重点。我们可以这样来分析：
     *
     * 我们希望下一个数比当前数大，这样才满足“下一个排列”的定义。因此只需要将后面的「大数」与前面的「小数」交换，就能得到一个更大的数。比如 123456，将 5 和 6 交换就能得到一个更大的数 123465。
     * 我们还希望下一个数增加的幅度尽可能的小，这样才满足“下一个排列与当前排列紧邻“的要求。为了满足这个要求，我们需要：
     * 在尽可能靠右的低位进行交换，需要从后向前查找
     * 将一个 尽可能小的「大数」 与前面的「小数」交换。比如 123465，下一个排列应该把 5 和 4 交换而不是把 6 和 4 交换
     * 将「大数」换到前面后，需要将「大数」后面的所有数重置为升序，升序排列就是最小的排列。以 123465 为例：首先按照上一步，交换 5 和 4，得到 123564；然后需要将 5 之后的数重置为升序，得到 123546。显然 123546 比 123564 更小，123546 就是 123465 的下一个排列
     * 以上就是求“下一个排列”的分析过程。
     *
     * 算法过程
     * 标准的“下一个排列”算法可以描述为：
     *
     * 从后向前查找第一个相邻升序的元素对 (i,j)，满足 A[i] < A[j]。此时 [j,end) 必然是降序
     * 在 [j,end) 从后向前查找第一个满足 A[i] < A[k] 的 k。A[i]、A[k] 分别就是上文所说的「小数」、「大数」
     * 将 A[i] 与 A[k] 交换
     * 可以断定这时 [j,end) 必然是降序，逆置 [j,end)，使其升序
     * 如果在步骤 1 找不到符合的相邻元素对，说明当前 [begin,end) 为一个降序顺序，则直接跳到步骤 4
     *
     * 作者：imageslr
     * 链接：https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     */

    public void nextPermutation1(int[] nums) {
        int length = nums.length;
        int flag = 0;
        for (int i = length - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                int minIndex = 0;
                int min = Integer.MAX_VALUE;
                for (int k = length - 1; k > i; k--) {
                    if (nums[i] < nums[k]) {
                        if (nums[k] < min) {
                            min = nums[k];
                            minIndex = k;
                        }
                    }
                }
                swap(nums, i, minIndex);

                flag = 1;
                Arrays.sort(nums, i + 1, length);

                for (int num : nums) {
                    System.out.print(num + "\t");
                }
                System.out.println();
                break;
            }
        }
        if (flag == 0) {
            for (int i = 0; i < length / 2; i++) {
                swap(nums, i, length - 1 - i);
            }
        }
    }


    public void nextPermutation2(int[] nums) {
        int l = 0, r = nums.length - 1;
        // 找到第一个升序相邻数
        for (int i = r; i > 0; i--) {
            if (nums[i] > nums[i - 1]){
                l = i;
                break;
            }
        }
        for (int i = r; l > 0 && i > l - 1 ; i--) {
            if (nums[i] > nums[l - 1]) {
                swap(nums, i, l - 1);
                break;
            }
        }
        while (l < r){
            swap(nums, l++, r--);
        }
        for (int num : nums) {
            System.out.print(num + "\t");
        }
        System.out.println();
    }










    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }



    public void nextPermutation3(int[] nums) {
        int l = 0, r = nums.length - 1;
        // 找到升序相邻数
        for (int i = r; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                l = i;
                break;
            }
        }
        // 说明从i开始到r都是降序
        // 找到从l到r的第一个大于l - 1的数
        for (int i = r; l > 0 && i > l - 1; i--) {
            if (nums[i] > nums[l - 1]) {
                swap(nums, l - 1, i);
                break;
            }
        }

        // 从l 到 r进行排序
        while (l < r) {
            swap(nums, l++, r--);
        }
    }

    public void nextPermutation(int[] nums) {
        int l = 0, r = nums.length - 1;
        for(int i = r; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                l = r;
                break;
            }
        }

        for(int i = r; l > 0 && i > l - 1; i--) {
            if (nums[i] > nums[l - 1]) {
                swap(nums, i, l - 1);
                break;
            }
        }

        while (l < r) {
            swap(nums, l--, r++);
        }
    }

    @Test
    public void test() {
        nextPermutation(new int[]{1,8,7,6,1,4,3,2});
    }
}
