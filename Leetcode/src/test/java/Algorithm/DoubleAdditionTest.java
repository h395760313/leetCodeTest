package Algorithm;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * 双指针测试类
 * @Author: xiehy
 * @Date: 2021/2/22
 */
public class DoubleAdditionTest {

    /**
     * 167. 两数之和 II - 输入有序数组(Two Sum)
     */
    @Test
    public void twoSumTest() {
        int[] arr = {5,25,75};
        int target = 100;
        System.out.println(JSON.toJSONString(DoubleAddition.twoSum(arr,target)));
    }

    /**
     * 88. 合并两个有序数组(Merge Sorted Array)
     */
    @Test
    public void mergeTest() {
        int[] arr1 = {1,2,3,0,0,0}, arr2 = {2,5,6};
        int m = 3, n = 3;
        DoubleAddition.merge(arr1,m,arr2,n);
    }

    /**
     *  76.最小覆盖子串(Minimum Window Substring)
     */
    @Test
    public void minWindowTest() {
        String s = "ADOBECODEBANC",t = "ABC";
        DoubleAddition.minWindow(s,t);
    }

    @Test
    public void judgeSquareSumTest() {
        int c = 5;
        System.out.println(JSON.toJSONString(DoubleAddition.judgeSquareSum(c)));
    }

    @Test
    public void debugTest() {
        int i = 99;
        method(i);
    }

    private static void method(int j){
        j++;
        System.out.println(j);
    }
}
