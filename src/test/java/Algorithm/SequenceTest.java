package Algorithm;

import com.algorithm.leetCode.common.ListNode;
import com.algorithm.leetCode.common.TreeNode;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;

public class SequenceTest {

    /**
     * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
     * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
     * 示例 1：
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[[1,4,7],[2,5,8],[3,6,9]]
     * 示例 2：
     * 输入：matrix = [[1,2,3],[4,5,6]]
     * 输出：[[1,4],[2,5],[3,6]]
     */
    @Test
    public void transpose() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        int len1 = matrix[0].length;
        int len2 = matrix.length;
        int[][] arr = new int[len1][len2];
        for (int i = 0; i < len2; i++) {
            for (int j = 0; j < len1; j++) {
                arr[j][i] = matrix[i][j];
            }
        }

        System.out.println(JSON.toJSONString(arr));
    }

    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例 1：
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * <p>
     * 示例 2：
     * 输入：l1 = [0], l2 = [0]
     * 输出：[0]
     * <p>
     * 示例 3：
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     */
    @Test
    public void addTwoNumbers() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode res = new ListNode();
        ListNode curr = res;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l2 != null ? l2.val : 0;
            int y = l1 != null ? l1.val : 0;

            int sum = carry + x + y;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l2 != null) l2 = l2.next;
            if (l1 != null) l1 = l1.next;

        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        System.out.println(JSON.toJSONString(res.next));

    }

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例 1:
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * <p>
     * 示例 2:
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * <p>
     * 示例 3:
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * <p>
     * 示例 4:
     * 输入: s = ""
     * 输出: 0
     */
    @Test
    public void lengthOfLongestSubstring() {
        String s = "abcabcbb";
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int start = 0, end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c));
            }
            res = Math.max(res, end - start + 1);
            map.put(c, end + 1);
        }
        System.out.println(res);
    }

    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * <p>
     * 示例 1：
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * <p>
     * 示例 2：
     * 输入：s = "cbbd"
     * 输出："bb"
     * <p>
     * 示例 3：
     * 输入：s = "a"
     * 输出："a"
     * <p>
     * 示例 4：
     * 输入：s = "ac"
     * 输出："a"
     * <p>
     * 提示：
     * 1 <= s.length <= 1000
     * s 仅由数字和英文字母（大写和/或小写）组成
     * Related Topics 字符串 动态规划
     */
    @Test
    public void longestPalindromeTest1() {
//        String s = "aaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwxxxxxxxxxxyyyyyyyyyyzzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvvuuuuuuuuuuttttttttttssssssssssrrrrrrrrrrqqqqqqqqqqppppppppppoooooooooonnnnnnnnnnmmmmmmmmmmllllllllllkkkkkkkkkkjjjjjjjjjjiiiiiiiiiihhhhhhhhhhggggggggggffffffffffeeeeeeeeeeddddddddddccccccccccbbbbbbbbbbaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwxxxxxxxxxxyyyyyyyyyyzzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvvuuuuuuuuuuttttttttttssssssssssrrrrrrrrrrqqqqqqqqqqppppppppppoooooooooonnnnnnnnnnmmmmmmmmmmllllllllllkkkkkkkkkkjjjjjjjjjjiiiiiiiiiihhhhhhhhhhggggggggggffffffffffeeeeeeeeeeddddddddddccccccccccbbbbbbbbbbaaaa";
//        String s = "a";
//        System.out.println(longestPalindrome(s));

        if (new ArrayList<Integer>() instanceof List)
            System.out.println("ArrayList是 java.util.List 类的实例");
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        String res = "";
        boolean[][] b = new boolean[len][len];
        long start = System.currentTimeMillis();
        for (int l = 0; l < s.length(); l++) {
            for (int i = 0; i < s.length() - l; i++) {
                int j = i + l;
                if (l == 0) {
                    b[i][j] = true;
                } else if (l == 1) {
                    b[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    b[i][j] = s.charAt(i) == s.charAt(j) && b[i + 1][j - 1];
                }
                if (b[i][j] && l + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        return res;
    }

    public static void displayObjectClass(Object o) {

        if (o instanceof Vector)
            System.out.println("对象是 java.util.Vector 类的实例");
        if (new ArrayList<Integer>() instanceof List)
            System.out.println("ArrayList是 java.util.List 类的实例");
    }


    /**
     * 11.盛最多水的容器
     */
    @Test
    public void maxArea() {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }


    public static int maxArea(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length - 1;
        int len = height.length - 1;

        while (l < r) {
            res = Math.max(len * Math.min(height[l], height[r]), res);
            System.out.println(len + " * min(" + height[l] + "," + height[r] + ")");
            System.out.println(len + " * " + Math.min(height[l], height[r]) + " = " + len * Math.min(height[l], height[r]));
            System.out.println("=================");

            if ((height[l] < height[r])) {
                l++;
            } else {
                r--;
            }
            len--;
        }
        return res;
    }

    /**
     * [118]杨辉三角
     */
    @Test
    public void generateTest() {
        List<List<Integer>> generate = generate(3);
        for (List<Integer> integers : generate) {
            System.out.println(JSON.toJSONString(integers));
        }
    }

    /**
     * [119]杨辉三角2
     */
    @Test
    public void getRowTest() {
        List<Integer> generate = getRow(3);
        for (Integer integers : generate) {
            System.out.println(JSON.toJSONString(integers));
        }
    }

    /**
     * n行，从第1行到第n行
     * 每一行，a1，a2，a3……，aj。
     * 每行第a1个和第aj个都为1，中间第二个为前一行第一个和第二个之和...中间第三个为前一行第二个和第三个之和
     *
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> BigList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                    continue;
                }
                list.add(BigList.get(i - 1).get(j - 1) + BigList.get(i - 1).get(j));
            }
            BigList.add(list);
        }
        return BigList;
    }

    /**
     * n行，从第1行到第n行
     * 每一行，a1，a2，a3……，aj。
     * 每行第a1个和第aj个都为1，中间第二个为前一行第一个和第二个之和...中间第三个为前一行第二个和第三个之和
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> bigList = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                    continue;
                }
                list.add(bigList.get(i - 1).get(j - 1) + bigList.get(i - 1).get(j));
            }
            bigList.add(list);
        }
        return bigList.get(rowIndex);
    }

    /**
     * [121]买卖股票的最佳时机
     */
    @Test
    public void maxProfitTest() {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public static int maxProfit(int[] prices) {
//        int res = 0;
//        for (int i = 0; i < prices.length - 1; i++) {
//            for (int j = i + 1; j < prices.length; j++) {
//                res = Math.max(res,prices[j] - prices[i]);
//            }
//        }
//        return res;
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        System.out.println("第1天：");
        System.out.println("dp[i][0] = " + dp[0][0] + "    dp[i][1] = " + dp[0][1]);
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(-prices[i], dp[i - 1][1]);
            System.out.println("第" + (i + 1) + "天：");
            System.out.println("dp[i][0] = " + dp[i][0] + "    dp[i][1] = " + dp[i][1]);
        }
        return dp[len - 1][0];
    }

    /**
     * [169]多数元素
     */
    @Test
    public void majorityElement() {
        System.out.println(majorityElement(new int[]{2, 2, 2, 1, 1, 1, 2}));
    }

    /**
     * 摩尔投票法
     * 玩一个诸侯争霸游戏，假设我方人口超过总人口的一半，且每个人出去和敌军都能1v1同归于尽，最后还有人活下来的就是胜利
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        /*Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        int res = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            index = res < map.get(nums[i]) ? nums[i] : index;
            res = Math.max(res,map.get(nums[i]));
        }*/
        /*int num = nums[0];
        int count = 1;
        for (int i = 1;i<nums.length;i++) {
            if (nums[i] != num) {
                count --;
                if (count == 0){
                    count = 1;
                    num = nums[i];
                }
            }else count ++;
        }
        return num;*/

        int num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (num == nums[i]) {
                count++;
            } else if (--count == 0) {
                count = 1;
                num = nums[i];
            }
        }
        return num;
    }


    /**
     * [217]存在重复元素
     */
    @Test
    public void containsDuplicateTest() {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));
    }

    public static boolean containsDuplicate(int[] nums) {
        /*Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num,1);
            }else return true;
        }
        return false;*/
        /*Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        if (set.size() == nums.length) return false;
        return true;*/
        return Arrays.stream(nums).distinct().count() == nums.length ? false : true;
    }

    /**
     * [219]存在重复元素 II
     */
    @Test
    public void containsNearbyDuplicateTest() {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        /*for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && Math.abs( j - i ) <= k){
                    return true;
                }
            }
        }
        return false;*/
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && (i - map.get(nums[i])) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    /**
     * [38]外观数列
     */
    @Test
    public void countAndSayTest() {
        System.out.println(countAndSay(5));
    }

    public String countAndSay(int n) {
        // 如果为1 直接返回1
        if (n == 1) return "1";
        // 利用递归进行n次判断
        String num = countAndSay(n - 1);
        // 创建StringBuilder用于拼接字符串
        StringBuilder sb = new StringBuilder();
        // 循环遍历
        for (int i = 0; i < num.length(); i++) {
            int count = 1;
            // 如果和后一个数相同，则count++，如果不相同，则判断下一个数
            while (i < num.length() - 1 && num.charAt(i) == num.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(count).append(num.charAt(i));
        }
        return sb.toString();
    }


    @Test
    public void Test() {
        String s = "hello world";
        System.out.println(lengthOfLastWord(s));
    }

    public int lengthOfLastWord(String s) {
        /*if (s.trim().length() == 0) return 0;
        String[] str = s.split(" ");
        return s.split(" ")[s.split(" ").length - 1].length();*/
        //执行耗时:6 ms,击败了5.23% 的Java用户
        //内存消耗:38.8 MB,击败了5.08% 的Java用户

        /*if (s.trim().length() == 0) return 0;
        String[] str = s.split(" ");
        return s.split(" ")[s.split(" ").length - 1].length();*/

        int end = s.length() - 1;
        // 从字符串末尾取最后一位不为空格的字符所在位置 end
        while (end >= 0 && s.charAt(end) == ' ') end--;
        // 获取到end位置，从end开始往前遍历字符串开始的位置，遇空格或字符串头结束
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }

    /**
     * ✔[66]加一
     */
    @Test
    public void plusOne() {
        int[] ints = plusOne(new int[]{9, 9, 9});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] plusOne(int[] digits) {
        boolean flag = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                flag = true;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        if (flag) {
            int[] arr = new int[digits.length + 1];
            arr[0] = 1;
            arr[1] = 0;
            for (int i = 2; i < arr.length; i++) {
                arr[i] = digits[i - 1];
            }
            return arr;
        }
        return null;
    }

    /**
     * [67]二进制求和
     */
    @Test
    public void addBinary() {
        System.out.println(addBinary("11", "1"));
    }

    /**
     * 找到最大长度maxLen，长度短的数前面以0计算，如10011 + 100 = 10011 + 00100
     * 从两个数末尾开始相加，用flag表示是否进位，flag = (ai + bi + flag) % 2
     * 每一位相加是都加上flag arr[i] = a[i] + b[i] + flag
     * 遍历结束后判断flag是否是1，如果是1说明两个数最高位相加需要进位  比如 11 + 1 结果为100
     * 创建一个新数组  长度为maxLen + 1 第一位保存1 之后的res[i]等于arr[i-1]
     * 通过StringBuilder拼接字符串  获取最后结果
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        int ai = a.length() - 1;
        int bi = b.length() - 1;
        int maxLen = Math.max(a.length(), b.length());
        int len = maxLen;
        int flag = 0;
        int[] arr = new int[maxLen];
        while (len > 0) {
            int num = 0;
            if (ai < 0) {
                num = (0) + (b.charAt(bi) - '0') + flag;
            } else if (bi < 0) {
                num = (a.charAt(ai) - '0') + (0) + flag;
            } else {
                num = (a.charAt(ai) - '0') + (b.charAt(bi) - '0') + flag;
            }
            arr[len - 1] = (num) % 2;
            if (num >= 2) {
                flag = 1;
            } else {
                flag = 0;
            }
            ai--;
            bi--;
            len--;
        }
        StringBuilder sb = new StringBuilder();
        if (flag == 1) {
            int[] arr1 = new int[maxLen + 1];
            arr1[0] = 1;
            for (int i = 1; i <= maxLen; i++) {
                arr1[i] = arr[i - 1];
            }
            for (int i : arr1) {
                sb.append(i);
            }
        } else {
            for (int i : arr) {
                sb.append(i);
            }
        }
        return sb.toString();


    }


    @Test
    public void testLode() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        System.out.println(JSON.toJSONString(mergeTwoLists(l1, l2)));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }


    /**
     *    [28]实现 strStr()
     */
    @Test
    public void strStrTest (){
        System.out.println(strStr("a","a"));
    }

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        int p = 0;
        int q = needle.length();
        while (q <= haystack.length()){
            System.out.println("p = " + p);
            System.out.println("q = " + q);
            if (haystack.substring(p,q).equals(needle)){
                return p;
            }else{
                p ++; q ++;
            }
        }
        return -1;
    }

    /**
     *    [70]爬楼梯
     */
    @Test
    public void climbStairsTest (){
        System.out.println(climbStairs(5));
    }

    /**
     * [509]斐波那契数
     * f(x) = f(x − 1) + f(x − 2)
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        if (n < 2) return n;
        int i1 = 1,i2 = 2;
        for (int i = 3; i <= n; i++) {
            int temp = i1 + i2;
            i1 = i2;
            i2 = temp;
        }
        return i2;
    }

    /**
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(head.val);
        ListNode curr = res;
        while (head.next != null) {
            if (curr.val != head.next.val){
                curr.next = new ListNode(head.next.val);
                curr = curr.next;
            }
            head = head.next;
        }
        return res;
    }

    /**
     *    [83]删除排序链表中的重复元素
     */
    @Test
    public void deleteDuplicatesTest (){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);

        System.out.println(JSON.toJSONString(deleteDuplicates(l1)));
    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 如果两个树都为空则相等
        if (p == null && q == null) {
            return true;
        // 如果一个树为空另一个树不为空则不相等
        }else if (p == null || q == null) {
            return false;
        // 如果两个树的节点值不相等则树不相等
        }else if (p.val != q.val){
            return false;
        // 如果两个树的节点相等则继续遍历
        }else {
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
    }


    /**
     * ✔[100]相同的树
     */
    @Test
    public void isSameTreeTest(){

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(4);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        System.out.println(isSameTree(p,q));
    }


    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }

    public boolean check(TreeNode p,TreeNode q){
        // 如果树为空  则对称
        if (p == null && q == null) {
            return true;
        // 如果一个树为空，另一个树不为空  则不对称
        } else if (p == null || q == null) {
            return false;
        }
        // 两个树都不为空 判断是否节点相等 如果相等则继续判断下一个节点
        return q.val == p.val && check(p.left,q.right) && check(p.right,q.left);
    }

    /**
     *
     */
    @Test
    public void isSymmetricTest() {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.left.left = new TreeNode(3);
        p.left.right = new TreeNode(4);
        p.right = new TreeNode(2);
        p.right.left = new TreeNode(4);
        p.right.right = new TreeNode(3);
        System.out.println(isSymmetric(p));
    }


    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

    @Test
    public void maxDepthTest() {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.left.left = new TreeNode(4);
        p.right = new TreeNode(3);
        p.right.left = new TreeNode(5);
        p.right.right = new TreeNode(6);
        p.right.left.left = new TreeNode(7);
        p.right.right.left = new TreeNode(8);
        p.right.right.right = new TreeNode(9);
        p.right.right.right.right = new TreeNode(10);
        System.out.println(maxDepth(p));
    }

}
