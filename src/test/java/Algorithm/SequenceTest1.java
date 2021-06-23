package Algorithm;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class SequenceTest1 {

    /**
     *    [1]两数之和
     */
    @Test
    public void twoSumTest() {
        SequenceMethod1 sequenceMethod = new SequenceMethod1();
        System.out.println(JSON.toJSONString(sequenceMethod.twoSum(new int[]{3,2,4},6)));
    }

    /**
     *    [2]两数相加
     */
    @Test
    public void addTwoNumbersTest() {
        SequenceMethod1 sequenceMethod = new SequenceMethod1();
//        System.out.println(JSON.toJSONString(sequenceMethod.addTwoNumbers(new int[]{3,2,4},6)));
    }

    /**
     *    [3]无重复字符的最长子串
     */
    @Test
    public void lengthOfLongestSubstringTest(){
        SequenceMethod1 sequenceMethod = new SequenceMethod1();
        System.out.println(sequenceMethod.lengthOfLongestSubstring("abcabdab"));
    }

    /**
     *    [4]寻找两个正序数组的中位数
     */
    @Test
    public void findMedianSortedArraysTest(){
        SequenceMethod1 sequenceMethod = new SequenceMethod1();
        System.out.println(JSON.toJSONString(sequenceMethod.findMedianSortedArrays1(new int[]{1,3},new int[]{2})));
    }

    /**
     *    [5]最长回文子串
     */
    @Test
    public void longestPalindromeTest(){
        SequenceMethod1 sequenceMethod = new SequenceMethod1();
        System.out.println(JSON.toJSONString(sequenceMethod.longestPalindrome4("zbzgggdsgsdgsg")));
    }

    /**
     *    [6]Z 字形变换
     */
    @Test
    public void convertTest(){
        SequenceMethod1 sequenceMethod = new SequenceMethod1();
        System.out.println(sequenceMethod.convert2("ABC",2));
    }
    /**
     *    [7]整数反转
     */
    @Test
    public void reverseTest(){
        SequenceMethod1 sequenceMethod = new SequenceMethod1();
        System.out.println(sequenceMethod.reverse(-2147483648));
    }

    /**
     *    [15]三数之和
     */
    @Test
    public void threeSumTest(){
        SequenceMethod1 sequenceMethod = new SequenceMethod1();
        System.out.println(sequenceMethod.threeSum(new int[]{0,0,0}));
    }




}
