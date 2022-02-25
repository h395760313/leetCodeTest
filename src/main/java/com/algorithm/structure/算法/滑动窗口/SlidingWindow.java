package com.algorithm.structure.算法.滑动窗口;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.LinkedList;

/**
 * 滑动窗口，寻找以n为窗口大小的子数组中的最大值  使用双向队列
 * @author xiehongyu
 * @date 2022/02/23 16:10
 */
public class SlidingWindow {

    public int[] maxInWindow(int[] arr, int n) {

        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[arr.length - n + 1];
        int l = 1;
        int r = 0;
        int index = 0;

        while (r < arr.length && r < n) {
            if (!queue.isEmpty()) {
                while (!queue.isEmpty() && arr[queue.peekLast()] <= arr[r]) {
                    queue.pollLast();
                }
            }
            queue.offerLast(r++);
        }
        res[index++] = arr[queue.peekFirst()];

        while (r < arr.length) {
            if (!queue.isEmpty()) {
                if (queue.size() == n) {
                    queue.pollFirst();
                }
                while (!queue.isEmpty() && arr[queue.peekLast()] <= arr[r]) {
                    queue.pollLast();
                }
            }
            queue.offerLast(r++);
            res[index++] = arr[queue.peekFirst()];
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(JSON.toJSONString(maxInWindow(new int[]{5,3,6,2,1,7,4,1,3,5,7,9,2,1,4,6,8}, 3)));
        // 6 6 6 7 7 7 4 5 7 9 9 9 4 6 8
        //[6,6,6,7,7,7,4,5,7,9,9,9,4,6,8]
    }



}
