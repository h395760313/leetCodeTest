package com.algorithm.leetcode101._01_贪心算法;

import com.alibaba.fastjson.JSON;
import com.model.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.cn/problems/queue-reconstruction-by-height/
 * @Author: xiehongyu
 * @Date: 2022/05/09 21:03
 */
public class _08_根据身高重建队列 {

    public int[][] reconstructQueue(int[][] people) {
        int len = people.length;
        if (len <= 1) {
            return people;
        }
        Arrays.sort(people, Comparator.comparingInt(o -> o[1]));

        int i = 0;
        while (i < len) {
            int biggerCount = 0;
            for (int j = 0; j < i; j++) {
                if (people[j][0] >= people[i][0]) {
                    biggerCount++;
                }
            }
            if (biggerCount != people[i][1]) {
                swap(people, i, i - 1);
                i--;
            }else {
                i++;
            }
        }
        System.out.println(JSON.toJSONString(people));
        return people;
    }

    private void swap(int[][] people, int i, int j) {
        int[] temp = people[i];
        people[i] = people[j];
        people[j] = temp;
    }

    @Test
    public void test() {
        System.out.println(reconstructQueue(new int[][]{{2,4},{3,4},{9,0},{0,6},{7,1},{6,0},{7,3},{2,5},{1,1},{8,0}}));
    }
}
