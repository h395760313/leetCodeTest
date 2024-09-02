package Algorithm;

import com.alibaba.fastjson.JSON;

/**
 * 双指针
 *
 * @Author: xiehy
 * @Date: 2021/2/22
 */
public class DoubleAddition {


    /**
     * 给定一个已按照 升序排列 的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
     * <p>
     * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0]
     * < answer[1] <= numbers.length 。
     * <p>
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     * <p>
     * 示例 1：
     * 输入：numbers = [2,7,11,15], target = 9
     * 输出：[1,2]
     * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     * <p>
     * 示例 2：
     * 输入：numbers = [2,3,4], target = 6
     * 输出：[1,3]
     * <p>
     * 示例 3：
     * 输入：numbers = [-1,0], target = -1
     * 输出：[1,2]
     * 提示：
     * 2 <= numbers.length <= 3 * 104
     * -1000 <= numbers[i] <= 1000
     * numbers 按 递增顺序 排列
     * -1000 <= target <= 1000
     * 仅存在一个有效答案
     * <p>
     * Related Topics 数组 双指针 二分查找
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int index1 = 0;
        int index2 = len - 1;
        while (true) {
            if (numbers[index1] + numbers[index2] == target) {
                return new int[]{index1 + 1, index2 + 1};
            } else if (numbers[index1] + numbers[index2] < target) {
                index1++;
            } else {
                index2--;
            }
        }
    }


    /**
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
     * <p>
     * 示例 1：
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * <p>
     * 示例 2：
     * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
     * 输出：[1]
     * <p>
     * 提示：
     * nums1.length == m + n
     * nums2.length == n
     * 0 <= m, n <= 200
     * 1 <= m + n <= 200
     * -109 <= nums1[i], nums2[i] <= 109
     * <p>
     * Related Topics 数组 双指针
     *
     * @Author: xiehy
     * @Date: 2021/2/22
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        long start = System.currentTimeMillis();
        int[] copyArr = new int[m];
        System.arraycopy(nums1, 0, copyArr, 0, m);

        int p1 = 0, p2 = 0, index = 0;
        while (p1 < m && p2 < n) {
            nums1[index++] = copyArr[p1] <= nums2[p2] ? copyArr[p1++] : nums2[p2++];
        }
        if (p1 < m) {
            System.arraycopy(copyArr, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
//        System.arraycopy(nums2,0,nums1,m,n);
//        Arrays.sort(nums1);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(JSON.toJSONString(nums1));
    }

    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
     * <p>
     * 示例 1：
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     * <p>
     * 示例 2：
     * 输入：s = "a", t = "a"
     * 输出："a"
     * <p>
     * 提示：
     * 1 <= s.length, t.length <= 105
     * s 和 t 由英文字母组成
     * <p>
     * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window
     *
     * @param s
     * @param t
     * @return
     */
    // todo
    public static String minWindow(String s, String t) {
        if (s.contains(t)) return t;

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        String res = "";
        int len = 0;

        int l = 0;

        for (int i = 0; i < t.length(); i++) {
            l = Math.min(l, s.indexOf(String.valueOf(tChars[i])));
            if (!s.contains(String.valueOf(tChars[i]))) {
                return "";
            }
        }

        int r = l;


        for (int i = 0; i < s.length(); i++) {

        }
        return res;
    }

    /**
     * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
     * <p>
     * 示例 1：
     * 输入：c = 5
     * 输出：true
     * 解释：1 * 1 + 2 * 2 = 5
     * <p>
     * 示例 2：
     * 输入：c = 3
     * 输出：false
     * <p>
     * 示例 3：
     * 输入：c = 4
     * 输出：true
     * <p>
     * 示例 4：
     * 输入：c = 2
     * 输出：true
     * <p>
     * 示例 5：
     * 输入：c = 1
     * 输出：true
     * <p>
     * 提示：
     * 0 <= c <= 231 - 1
     * Related Topics 数学
     *
     * @param c
     * @return
     */
    public static boolean judgeSquareSum(int c) {

        /*int start = 0;
        int end = c;
        int mid;
        int num = c - (int)Math.pow(end,2);
        System.out.println(num);
        while (start <= end) {
            mid = (start + end) / 2;
            if (Math.pow(mid,2) == num) {
                return true;
            }else if (Math.pow(mid,2) > num){
                end = mid;
            }else {
                start = mid;
            }
        }
        return false;*/
        for (int i = 0; Math.pow(i,2) <= c; i++) {
            double sqrt = Math.sqrt(c - Math.pow(i, 2));
            if (sqrt == (int)sqrt){
                return true;
            }
        }
        return false;
    }

}
