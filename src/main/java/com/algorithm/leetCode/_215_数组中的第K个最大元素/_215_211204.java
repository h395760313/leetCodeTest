package com.algorithm.leetCode._215_数组中的第K个最大元素;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author xiehongyu
 * @date 2021/12/04 10:59
 */
public class _215_211204 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k) {
                queue.offer(nums[i]);
            }else if (nums[i] > queue.peek()) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }

        Object[] arr = queue.toArray();
        Arrays.sort(arr);

        return (int)arr[0];
    }

    @Test
    public void test(){
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}
