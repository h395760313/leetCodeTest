package com.algorithm.leetCode._128_最长连续序列;

import com.alibaba.fastjson.JSON;
import com.algorithm.structure._8_哈希表.Map;
import org.junit.Test;

/**
 * @author xiehongyu
 * @date 2021/12/21 17:20
 */
public class _128_最长连续序列_template {


    private int[] parents;
    Map<Integer, Integer> rank;

    // 0,3,2,1,4
    public int longestConsecutive(int[] nums) {
        parents = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            parents[i] = i;
            rank.put(nums[i], 1);
        }

        // parent: 0,1,2,3,4
        // rank:   (0,1),(3,1),(2,1),(1,1),(4,1)

        int num = 0;




        for (int i = 0; i < nums.length; i++) {

        }
        return 0;
    }

    /**
     *
     * @param v
     * @return
     */
    private int find(int v){
        if (v < 0 || v >= parents.length) {
            throw new IllegalArgumentException("exception");
        }
        while (v != parents[v]) {
            int p = parents[v];
            parents[v] = parents[parents[v]];
            v = p;
        }
        return parents[v];
    }


    private void union(int v1, int v2){
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) return;

        if (rank.get(p1) > rank.get(p2)) {
            parents[p2] = p1;
        }else if (rank.get(p1) < rank.get(p2)) {
            parents[p1] = p2;
        }else {
            parents[p1] = p2;
            rank.put(p1, rank.get(p1) + 1);
        }
    }
//
//    public int longestConsecutive(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//
//        int maxLen = 0;
//        for (int i = 0; i < nums.length; i++) {
//            set.add(nums[i]);
//        }
//
//        for (Integer num : set) {
//            if (!set.contains(num - 1)) {
//                int currentNum = num;
//                int len = 1;
//
//                while (set.contains(currentNum + 1)) {
//                    currentNum++;
//                    len++;
//                }
//
//                maxLen = Math.max(maxLen, len);
//            }
//        }
//        return maxLen;
//    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(longestConsecutive(new int[]{0,3,2,1,4})));
    }
}
