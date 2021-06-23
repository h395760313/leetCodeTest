package Algorithm;


import com.algorithm.ListNode;
import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.stream.Collectors;

public class SequenceMethod1 {


    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     * 示例 1：
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * 示例 2：
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     * 示例 3：
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     * 只会存在一个有效答案
     * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
     * Related Topics 数组 哈希表
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution!");
    }

    public int[] twoSum1(int[] nums, int target) {
        int[] ret = {0, nums.length - 1};
        while (ret[0] != ret[1]) {
            int part1 = nums[ret[0]];
            int part2 = nums[ret[1]];
            if (part1 + part2 == target) return ret;
            for (int i = ret[0] + 1; i < ret[1]; i++) {
                if (nums[i] + part1 == target) {
                    ret[1] = i;
                    return ret;
                }
            }
            for (int i = ret[1] - 1; i > ret[0]; i--) {
                if (nums[i] + part2 == target) {
                    ret[0] = i;
                    return ret;
                }
            }
            ret[0]++;
            ret[1]--;
        }
        return null;
    }

    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * 示例 1：
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * 示例 2：
     * 输入：l1 = [0], l2 = [0]
     * 输出：[0]
     * 示例 3：
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     * 提示：
     * 每个链表中的节点数在范围 [1, 100] 内
     * 0 <= Node.val <= 9
     * 题目数据保证列表表示的数字不含前导零
     * Related Topics 递归 链表 数学
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 创建新链表
        ListNode res = new ListNode(0);
        ListNode curr = res;
        int carry = 0; // 进位
        while (l1 != null || l2 != null) {
            // 取值  空为0
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;

            // 求和
            int sum = x + y + carry;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);

            // 三指针后移
            curr = curr.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        // 还有没有进位
        if (carry > 0) curr.next = new ListNode(carry);
        return res.next;
    }

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * 示例 1:
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * 示例 4:
     * 输入: s = ""
     * 输出: 0
     * 提示：
     * 0 <= s.length <= 5 * 104
     * s 由英文字母、数字、符号和空格组成
     * Related Topics 哈希表 双指针 字符串 Sliding Window
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {

            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c));
            }
            res = Math.max(res, end - start + 1);
            map.put(c, end + 1);
        }
        return res;
    }

    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     * 示例 1：
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int q = 0, p = 0;
        int[] arr = new int[nums1.length + nums2.length];
        int tag = 0;
        while (q < nums1.length || p < nums2.length) {
            if (q < nums1.length && (p == nums2.length || nums1[q] < nums2[p])) {
                arr[tag++] = nums1[q];
                q++;
            } else {
                arr[tag++] = nums2[p];
                p++;
            }
        }
        if (arr.length % 2 == 0) {
            return (double)(arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;
        } else return arr[arr.length / 2];
    }


    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     *  示例 1：
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     *  示例 2：
     * 输入：s = "cbbd"
     * 输出："bb"
     *  示例 3：
     * 输入：s = "a"
     * 输出："a"
     *  示例 4：
     * 输入：s = "ac"
     * 输出："a"
     *  提示：
     *  1 <= s.length <= 1000
     *  s 仅由数字和英文字母（大写和/或小写）组成
     *  Related Topics 字符串 动态规划
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        // 1. 暴力解法
        int max = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isPalindrome(s.substring(i,j)) && (j - i) > max){
                    res = s.substring(i,j);
                    max = Math.max(max, res.length());
                }
            }
        }
        return res;
    }
    public String longestPalindrome2(String s) {
        // 2. 最长公共字串
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int len = s.length();
        int[][] arr = new int[len][len];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (origin.charAt(i) == reverse.charAt(j)){
                    if (i == 0 || j == 0){
                        arr[i][j] = 1;
                    }else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                if (arr[i][j] > maxLen) {
                    maxLen = arr[i][j];
                    maxEnd = i;
                }
            }
        }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);

    }
    public String longestPalindrome3(String s) {
        // 3. 动态规划
        int length = s.length();
        int maxLen = 0;
        String res = "";
        boolean[][] p = new boolean[length][length];
        for (int len = 1; len <= length; len++) {
            for (int start = 0; start < length; start++) {
                int end = start + len - 1;
                if (end >= length) break;
                p[start][end] = (len == 1 || len == 2 || p[start + 1][end - 1]) &&  s.charAt(start) == s.charAt(end);
                if (p[start][end] && len > maxLen){
                    res = s.substring(start,end + 1);
                    maxLen = len;
                }
            }
        }
        return res;
    }
    public String longestPalindrome4(String s) {
        if (s.length() < 2) return s;
        // 处理字符串
        String str = addBoundAries(s, '#');

        int maxLen = 1;
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            int curLen = valid(str, i);
            if (curLen > maxLen) {
                maxLen = curLen;
                start = (i - maxLen) / 2;
            }
        }
        return s.substring(start, maxLen + start);

    }

    private int valid(String s, int center) {
        int i = center - 1;
        int j = center + 1;

        int curLen = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
            curLen++;
        }
        return curLen;
    }

    /***
     * 创建预处理字符串
     * @param s 原始字符串
     * @param divide 分隔字符
     * @return 使用分隔字符处理以后得到的字符串
     */
    private String addBoundAries(String s, char divide) {
        StringBuffer sb = new StringBuffer();
        sb.append(divide);
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append(divide);
        }
        return sb.toString();
    }

    private boolean isPalindrome(String s){
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)){
                return false;
            }
        }
        return true;
    }

    /**
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     *  比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     *  之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     *  请你实现这个将字符串进行指定行数变换的函数：
     * string convert(string s, int numRows);
     *  示例 1：
     * 输入：s = "PAYPALISHIRING", numRows = 3
     * 输出："PAHNAPLSIIGYIR"
     * 示例 2：
     * 输入：s = "PAYPALISHIRING", numRows = 4
     * 输出："PINALSIGYAHRPI"
     * 解释：
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     *  示例 3：
     * 输入：s = "A", numRows = 1
     * 输出："A"
     *  提示：
     *  1 <= s.length <= 1000
     *  s 由英文字母（小写和大写）、',' 和 '.' 组成
     *  1 <= numRows <= 1000
     *  Related Topics 字符串
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (s.length() < 2) return s;
        if (numRows == 1) return s;
        char[][] arr = new char[numRows][s.length()];
        int num;
        int i = 0; // 列
        int j = 0; // 行
        boolean flag = true; // true 为正序 false 为倒序
        for (int k = 0; k < s.length(); k++) {
            char c = s.charAt(k);
            if (flag) {
                arr[j][i] = c;
                if (j == numRows - 1) {
                    i++;
                    j--;
                    flag = false;
                }else j++;

            }else {
                arr[j][i] = c;
                if (j == 0) {
                    flag = true;
                    j++;
                }else {
                    i++;
                    j--;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for (char[] chars : arr) {
            for (char c : chars) {
                if (c != 0){
                    sb.append(c);
                }
                sb.append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public String convert1(String s, int numRows) {
        if (s.length() < 2 ) return s;
        if (numRows < 2) return s;
        List<StringBuffer> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuffer());
        }
        int row = 0;
        int flag = -1;
        for (int i = 0; i < s.length(); i++) {
            list.get(row).append(s.charAt(i));
            if (row == 0 || row == numRows - 1) flag = -flag;
            row += flag;
        }
        StringBuffer sb = new StringBuffer();
        for (StringBuffer stringBuffer : list) {
            sb.append(stringBuffer);
        }
        return sb.toString();
    }

    public String convert2(String s, int numRows) {
       if (numRows < 2) return s;
       List<StringBuffer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(new StringBuffer());
        }
        int row = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            list.get(row).append(s.charAt(i));
            if (row == numRows - 1 || row == 0) {
                flag = !flag;
            }
            if (flag) {
                row+=1;
            }else {
                row-=1;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (StringBuffer stringBuffer : list) {
            sb.append(stringBuffer);
        }
        return sb.toString();
    }


    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     *  如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     *  示例 1：
     * 输入：x = 123
     * 输出：321
     * 输入：x = -123
     * 输出：-321
     * 输入：x = 120
     * 输出：21
     * 输入：x = 0
     * 输出：0
     *  Related Topics 数学
     * @param x
     * @return
     */
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int temp = x % 10;
            if (res > (Math.pow(2,31)) || (res == (Math.pow(2,31) - 1) && temp > 7)){
                return 0;
            }
            if (res < (Math.pow(-2,31)) || (res == (Math.pow(2,31)) && temp < -8)){
                return 0;
            }
            res = res * 10 + temp;
            x /= 10;
        }
        return res;
    }

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
     * 复的三元组。
     *  注意：答案中不可以包含重复的三元组。
     *  示例 1：
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     *  示例 2：
     * 输入：nums = []
     * 输出：[]
     *  示例 3：
     * 输入：nums = [0]
     * 输出：[]
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int x = i + 1;
            int y = len - 1;
            while (x < y) {
                int sum = nums[i] + nums[x] + nums[y];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[x], nums[y]));
                    while (x < y && nums[x] == nums[x + 1]) x++;
                    while (x < y && nums[y] == nums[y - 1]) y--;
                    x++;y--;
                }else if (sum < 0) x++;
                else y--;
            }
        }
        return list;
    }

}









