package Algorithm;


import com.algorithm.ListNode;
import java.util.*;

public class SequenceMethod1 {


    /******************   [1]两数之和    ******************
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

    /******************    [2]两数相加   ******************
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

    /******************   [3]无重复字符的最长子串    ******************
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

    /******************   [4]寻找两个正序数组的中位数    ******************
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


    /******************   [5]最长回文子串    ******************
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
    // 1. 暴力解法
    public String longestPalindrome1(String s) {
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
    // 2. 最长公共字串
    public String longestPalindrome2(String s) {
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
    // 3. 动态规划
    public String longestPalindrome3(String s) {
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
    // 马拉车
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

    /**
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

    /******************   [6]Z 字形变换    ******************
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


    /******************   [7]整数反转    ******************
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


    /******************   [8]字符串转换整数 (atoi)    ******************
     * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
     *  函数 myAtoi(string s) 的算法如下：
     *  读入字符串并丢弃无用的前导空格
     *  检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
     *  读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
     *  将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤
     * 2 开始）。
     *  如果整数数超过 32 位有符号整数范围 [−231, 231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固
     * 定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
     *  返回整数作为最终结果。
     *  注意：
     *  本题中的空白字符只包括空格字符 ' ' 。
     *  除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
     *  示例 1：
     * 输入：s = "42"
     * 输出：42
     * 解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
     * 第 1 步："42"（当前没有读入字符，因为没有前导空格）
     *          ^
     * 第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
     *          ^
     * 第 3 步："42"（读入 "42"）
     *            ^
     * 解析得到整数 42 。
     * 由于 "42" 在范围 [-231, 231 - 1] 内，最终结果为 42 。
     *  Related Topics 字符串
     */
    public int myAtoi(String s) {
        int index = 0;
        int len = s.length();
        // 消除前导空格
        while (index < len && s.charAt(index) == ' ') index++;
        if (index == len) return 0;
        // 正负号
        int flag = 1;
        int firstChar = s.charAt(index);
        if (firstChar == '+'){
            index++;
        }else if (firstChar == '-'){
            flag = -1;
            index++;
        }
        int res = 0;
        while (index < len){
            // 验证不合法
            char c = s.charAt(index);
            if (c > '9' || c < '0'){
                break;
            }
            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && (c - '0') > Integer.MAX_VALUE % 10){
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && (c - '0') > -(Integer.MIN_VALUE % 10)){
                return -Integer.MIN_VALUE;
            }
            res = res * 10 + (c - '0') * flag;
            index++;
        }
        return res;
    }

    /******************   [9]回文数    ******************
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     *  回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
     *  示例 1：
     * 输入：x = 121
     * 输出：true
     *  示例 2：
     * 输入：x = -121
     * 输出：false
     * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     *  Related Topics 数学
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int help = 1;
        int temp = x;
        while (temp >= 10) {
            help *= 10;
            temp /= 10;
        }
        while (x != 0){
            if (x % 10 != x / help) return false;
            x = x % help / 10;
            help /= 100;
        }
        return true;
    }

    /******************   [11]盛最多水的容器    ******************
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
     * ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *  说明：你不能倾斜容器。
     *  示例 1：
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     *  示例 2：
     * 输入：height = [1,1]
     * 输出：1
     *  示例 3：
     * 输入：height = [4,3,2,1,4]
     * 输出：16
     *  示例 4：
     * 输入：height = [1,2,1]
     * 输出：2
     *  Related Topics 贪心 数组 双指针
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;

        while (l < r){
            max = Math.max(Math.min(height[l],height[r]) * (r - l),max);
            if (height[l+1] > height[l]){
                l++;
            }else r--;
        }
        return max;
    }

    /******************   [14]最长公共前缀    ******************
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *  如果不存在公共前缀，返回空字符串 ""。
     *  示例 1：
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     *  示例 2：
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     *  Related Topics 字符串
     */
    public String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer();
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLen) minLen = strs[i].length();
        }
        for (int i = 0; i < minLen; i++) {
            char temp = strs[0].charAt(i);
            boolean flag = true;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != temp) flag = false;
            }
            if (flag) sb.append(temp);
            else break;
        }
        return sb.toString();
    }


    /******************   [15]三数之和    ******************
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
     *  提示：
     *  0 <= nums.length <= 3000
     *  -105 <= nums[i] <= 105
     *  Related Topics 数组 双指针 排序
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        List<List<Integer>> list = new ArrayList<>();
        if (i > 0 && nums[i] == nums[i+1]) i++;
        while (i < nums.length - 3){
            int x = i + 1;
            int y = nums.length - 1;
            while (x < y){
                int sum = nums[i] + nums[x] + nums[y];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[x], nums[y]));
                    if (x < y && nums[x] == nums[x+1]) x++;
                    if (x < y && nums[y] == nums[y-1]) y--;
                }
                x++;y--;
            }
            i++;
        }
        return list;
    }


    /******************   [16]最接近的三数之和    ******************
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
     * 。假定每组输入只存在唯一答案。
     *  示例：
     *  输入：nums = [-1,2,1,-4], target = 1
     *  [-4,-1,1,2]
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     *  Related Topics 数组 双指针 排序
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int x = i + 1;
            int y = nums.length - 1;
            while (x < y){
                int sum = nums[i] + nums[x] + nums[y];
                if (Math.abs(sum - target) < min) {
                    res = sum;
                    min = Math.abs(sum - target);
                }
                if (sum == target) return sum;
                else if (sum < target) x++;
                else if (sum > target) y--;
            }
        }
        return res;
    }
    /******************    todo[17]电话号码的字母组合   ******************
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     *  给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *  示例 1：
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     *  示例 2：
     * 输入：digits = ""
     * 输出：[]
     *  示例 3：
     * 输入：digits = "2"
     * 输出：["a","b","c"]
     *  0 <= digits.length <= 4
     *  digits[i] 是范围 ['2', '9'] 的一个数字。
     *  Related Topics 哈希表 字符串 回溯
     */
    public List<String> letterCombinations(String digits) {
        return null;
    }

    /******************    [18]四数之和   ******************
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
     *  d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     *  注意：答案中不可以包含重复的四元组。
     *  示例 1：
     * 输入：nums = [1,0,-1,0,-2,2], target = 0
     * [-2,-1,0,0,1,2]
     * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     *  示例 2：
     * 输入：nums = [], target = 0
     * 输出：[]
     *  提示：
     *  0 <= nums.length <= 200
     *  -109 <= nums[i] <= 109
     *  -109 <= target <= 109
     *  Related Topics 数组 双指针 排序
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 4) return list;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i + 1]) i++;
            for (int j = i + 1; j < nums.length - 2; j++) {
//                if (j > 0 && nums[j] == nums[j + 1]) j++;
                int x = j + 1;
                int y = nums.length - 1;
                while (x < y) {
                    int sum = nums[i] + nums[j] + nums[x] + nums[y];
                    if (sum == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[x], nums[y]));
                        if (x < y && nums[x] == nums[x + 1]) x++;
                        if (x < y && nums[y] == nums[y - 1]) y--;
                        x++;y--;
                    }else if (sum > target)y--;
                    else x++;
                }
            }
        }
        return list;
    }





    /******************    [39]组合总和    ******************
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *  candidates 中的数字可以无限制重复被选取。
     *  说明：
     *  所有数字（包括 target）都是正整数。
     *  解集不能包含重复的组合。
     *  示例 1：
     *
     *  输入：candidates = [2,3,6,7], target = 7,
     * 所求解集为：
     * [
     *   [7],
     *   [2,2,3]
     * ]
     *  示例 2：
     *  输入：candidates = [2,3,5], target = 8,
     * 所求解集为：
     * [
     *   [2,2,2,2],
     *   [2,3,3],
     *   [3,5]
     * ]
     *  提示：
     *  1 <= candidates.length <= 30
     *  1 <= candidates[i] <= 200
     *  candidate 中的每个元素都是独一无二的。
     *  1 <= target <= 500
     *  Related Topics 数组 回溯
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        for (int i = 0; i < target; i++) {
            for (int j = 0; j < i; j++) {

            }
        }
        return null;
    }

    /******************    [216]组合总和 III    ******************
     * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
     *  说明：
     *  所有数字都是正整数。
     *  解集不能包含重复的组合。
     *  示例 1:
     *  输入: k = 3, n = 7
     * 输出: [[1,2,4]]
     *  示例 2:
     *  输入: k = 3, n = 9
     * 输出: [[1,2,6], [1,3,5], [2,3,4]]
     *  Related Topics 数组 回溯
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        return null;
    }






}









