package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 贪心算法
 */
public class GreedyAlgorithm {

    /** 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
     * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，
     * 我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
     *
     *  示例 1:
     *
     * 输入: g = [1,2,3], s = [1,1]
     * 输出: 1
     * 解释:
     * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
     * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
     * 所以你应该输出1。
     * @param g 孩子列表
     * @param s 饼干列表
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        int cookie = 0;
        while (child < g.length && cookie < s.length) {
            if (g[child] <= s[cookie]) child++;
            cookie++;
        }
        return child;
    }

    /**
     * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
     * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
     * 每个孩子至少分配到 1 个糖果。
     * 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
     * 那么这样下来，老师至少需要准备多少颗糖果呢？
     *
     * 示例 1：
     * 输入：[1,0,2]
     * 输出：5
     * 解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
     * @param ratings 孩子分数
     * @return
     */
    public int candy(int[] ratings) {
        int len = ratings.length;
        if (len < 2) return len;
        int[] candy = new int[len];
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i-1]) candy[i] = candy[i-1] + 1;
        }
        for (int i = len -1; i > 0; i--) {
            if (ratings[i] < ratings[i-1]) candy[i-1] = Math.max(candy[i] + 1,candy[i-1]);
        }
        int count = len;
        for (int i = 0; i < candy.length; i++) {
            count += candy[i];
        }
        return count;
    }


    /**
     * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
     *  注意:
     *  可以认为区间的终点总是大于它的起点。
     *  区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
     *
     *  示例 1:
     * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
     * 输出: 1
     * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
     *  示例 2:
     * 输入: [ [1,2], [1,2], [1,2] ]
     * 输出: 2
     * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
     * @param intervals 区间数组
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;
        if (len == 0) return 0;
        int min = intervals[0][1];
        int res = 0;
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        for (int i = 1; i < len; i++) {
            if (min > intervals[i][0]){
                res ++;
                min = Math.min(min,intervals[i][1]);
            }else {
                min = intervals[i][1];
            }
        }
        return res;
    }

    /**
     * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
     *  给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则
     * 的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
     *
     *  示例 1：
     * 输入：flowerbed = [1,0,0,0,1], n = 1
     * 输出：true
     * @param flowerbed 花坛数组
     * @param n 种花数
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int res = 0;
        if (len == 1){
            if (flowerbed[0] == 0){
                res++;
            }
            return res == n;
        }
        if (flowerbed[0] == 0 && flowerbed[1] == 0){
            flowerbed[0] = 1;
            res ++;
        }
        for (int i = 1; i < len-1; i++) {
            if (flowerbed[i-1] == 0 && flowerbed[i+1] == 0 && flowerbed[i] == 0){
                flowerbed[i] = 1;
                res++;
            }
        }
        if (flowerbed[len-1] == 0 && flowerbed[len-2] == 0){
            flowerbed[len-1] = 1;
            res ++;
        }
        return res == n;
    }

    /**
     * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横
     * 坐标就足够了。开始坐标总是小于结束坐标。
     *
     *  一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足 xsta
     * rt ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的
     * 最小数量。
     *
     *  给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
     *
     *  示例 1：
     * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
     * 输出：2
     * 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
     *
     *  示例 2：
     * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
     * 输出：4
     * @param points 坐标
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        int len = points.length;
        if (len <=1){
            return len;
        }
        // {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}}
        Arrays.sort(points,Comparator.comparingInt(a->a[1]));
        // {{0,6},{2,8},{3,8},{6,8},{0,9},{2,9},{3,9},{3,9},{9,10},{7,12}}
        int cur = points[len-1][0];
        int res = 1;
        for (int i = len - 1; i >= 0; i--) {
            if (cur > points[i][1]){
                cur = points[i][1];
                res ++;
            }
        }
        return res;
    }

    /**
     * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
     *
     *  示例：
     * 输入：S = "ababcbacadefegdehijhklij"
     * 输出：[9,7,8]
     * 解释：
     * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
     * 每个字母最多出现在一个片段中。
     * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
     *
     *  提示：
     *  S的长度在[1, 500]之间。
     *  S只包含小写字母 'a' 到 'z' 。
     *
     *  Related Topics 贪心算法 双指针
     * @param S
     * @return
     */
    public List<Integer> partitionLabels(String S) {
        /*List<Integer> list = new ArrayList<>();
        char[] arr = S.toCharArray();
        int first = 0;
        int last = S.lastIndexOf(arr[0]);
        for (int i = 0; i < S.length(); i++) {
            if (i == last){
                list.add(last - first + 1);
                if (i == S.length()-1){
                    break;
                }
                first = i+1;
                last = S.lastIndexOf(arr[i+1]);
            }
            if (S.lastIndexOf(arr[i]) > last){
                last = S.lastIndexOf(arr[i]);
            }
        }
        return list;*/
        int[] arr = new int[26];
        int len = S.length();
        for (int i = 0; i < len; i++) {
            arr[S.charAt(i) - 'a'] = i;
        }
        List<Integer> list = new ArrayList<>();
        int start = 0,end = 0;
        for (int i = 0; i < len; i++) {
            end = Math.max(end,arr[S.charAt(i) - 'a']);
            if (end == i){
                list.add(end - start + 1);
                start = end + 1;
            }
        }
        return list;
    }

    /**
     *  给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *  设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     *  注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     *  示例 1:
     *  输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     *
     *  示例 2:
     *  输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     *     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     *
     *  示例 3:
     *  输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     *  提示：
     *  1 <= prices.length <= 3 * 10 ^ 4
     *  0 <= prices[i] <= 10 ^ 4
     *
     *  Related Topics 贪心算法 数组
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int money = 0;
        boolean flag = false;
        for (int i = 0; i < prices.length-1; i++) {
            if (!flag){
                if (prices[i+1] > prices[i] ){
                    money -= prices[i];
                    flag = true;
                }
            }else {
                if (prices[i+1] < prices[i] ){
                    money += prices[i];
                    flag = false;
                }
            }
        }
        if (flag){
            money += prices[prices.length-1];
        }
        return money;
    }

    /**
     * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i
     * 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
     *
     *  请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第
     *  j 个人的属性（queue[0] 是排在队列前面的人）。
     *
     *  示例 1：
     * 输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
     * 输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
     * 解释：
     * 编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
     * 编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
     * 编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
     * 编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
     * 编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
     * 编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
     * 因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。
     *
     *  示例 2：
     * 输入：people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
     * 输出：[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
     *
     *  提示：
     *
     *  1 <= people.length <= 2000
     *  0 <= hi <= 106
     *  0 <= ki < people.length
     *  题目数据确保队列可以被重建
     *
     *  Related Topics 贪心算法
     * @param people
     * @return
     */
    // todo 待完成
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,Comparator.comparingInt(a->a[1]));
        for (int i = 0; i < people.length-1; i++) {
            if (people[i][1] == people[i+1][1]){
                if (people[i][0] > people[i+1][0]){
                    int[] temp;
                    temp = people[i];
                    people[i] = people[i + 1];
                    people[i + 1] = temp;
                }
            }
        }

        
        for (int[] person : people) {
            for (int i : person) {
                System.out.print(i+"\t");
            }
            System.out.println();
        }
        return null;
    }

    /**
     * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
     *  我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
     *
     *  示例 1:
     * 输入: nums = [4,2,3]
     * 输出: true
     * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
     *
     *  示例 2:
     * 输入: nums = [4,2,1]
     * 输出: false
     * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
     *
     *  提示：
     *  1 <= n <= 10 ^ 4
     *  - 10 ^ 5 <= nums[i] <= 10 ^ 5
     *
     *  Related Topics 数组
     * @param nums
     * @return
     */
    // todo 待完成
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        int[] clone = nums.clone();
        boolean flag = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                nums[i] = nums[i + 1];
            }
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    flag = false;
                }
            }
            if (clone[i] > clone[i + 1]) {
                clone[i + 1] = clone[i];
            }
            for (int j = 0; j < clone.length - 1; j++) {
                if (clone[j] > clone[j + 1]) {
                    flag = false;
                }
            }
        }

        return flag;
    }
}