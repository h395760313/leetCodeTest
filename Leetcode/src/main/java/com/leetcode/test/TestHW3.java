package com.leetcode.test;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 题目描述：
 * 给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，其中answer[i]是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用0 来代替。
 * <p>
 * 解答要求
 * 时间限制：3000ms, 内存限制：100MB
 * <p>
 * 示例1:
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出:[1,1,4,2,1,1,0,0]
 * <p>
 * 示例 2:
 * 输入: temperatures = [30,40,50,60]
 * 输出:[1,1,1,0]
 * <p>
 * 示例 3:
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 * <p>
 * 提示：
 * 1 <=temperatures.length <= 100000
 * 30 <=temperatures[i]<= 100
 *
 * @Author: xiehongyu
 * @Date: 2024/06/27 14:54
 */
@Slf4j
public class TestHW3 {


    @Test
    public void test() {
        System.out.println(JSON.toJSONString(getDay(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));

    }


    private int[] getDay(int[] temperatures) {
//        int len = temperatures.length;
//        int[] res = new int[len];
//
//        for (int i = 0; i < len - 1; i++) {
//            for (int j = i + 1; j < len; j++) {
//                if (temperatures[j] > temperatures[i]) {
//                    res[i] = j - i;
//                    break;
//                }
//            }
//        }
//        return res;


//        int len = temperatures.length;
//        int[] res = new int[len];
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < len; i++) {
//            int finalI = i;
//            List<Integer> removeList = map.keySet().stream()
//                    .filter(key -> temperatures[finalI] > key)
//                    .collect(Collectors.toList());
//
//            for (Integer key : removeList) {
//                for (Integer index : map.get(key)) {
//                    res[index] = i - index;
//                    map.remove(key);
//                }
//            }
//            List<Integer> orDefault = map.getOrDefault(temperatures[i], new ArrayList<>());
//            orDefault.add(i);
//            map.put(temperatures[i], orDefault);
//        }
//        return res;


        int len = temperatures.length;
        int[] res = new int[len];
        int[] stack = new int[len];
        int r = 0;
        for (int i = 0; i < len; i++) {
            while (r > 0 && temperatures[i] > temperatures[stack[r]]) {
                int cur = stack[--r];
                res[cur] = i - cur;
            }
            stack[r++] = i;
        }

        return res;

    }
}
