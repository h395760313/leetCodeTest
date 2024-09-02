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
     *    [8]字符串转换整数 (atoi)
     */
    @Test
    public void myAtoiTest(){
        SequenceMethod1 sequenceMethod = new SequenceMethod1();
        System.out.println(sequenceMethod.myAtoi("  0000000000012345678"));
    }

    /**
     *    [9]回文数
     */
    @Test
    public void isPalindromeTest(){
        SequenceMethod1 sequenceMethod = new SequenceMethod1();
        System.out.println(sequenceMethod.isPalindrome(1000021));
    }

    /**
     *    [11]盛最多水的容器
     */
    @Test
    public void maxAreaTest(){
        SequenceMethod1 sequenceMethod = new SequenceMethod1();
        System.out.println(sequenceMethod.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }



    /**
     *    [14]最长公共前缀
     */
    @Test
    public void longestCommonPrefixTest(){
        SequenceMethod1 sequenceMethod = new SequenceMethod1();
        System.out.println(sequenceMethod.longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    /**
     *    [15]三数之和
     */
    @Test
    public void threeSumTest(){
        SequenceMethod1 sequenceMethod = new SequenceMethod1();
        System.out.println(sequenceMethod.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    /**
     *    [16]最接近的三数之和
     */
    @Test
    public void threeSumClosestTest(){
        SequenceMethod1 sequenceMethod = new SequenceMethod1();
        System.out.println(sequenceMethod.threeSumClosest(new int[]{-1,2,1,-4},1));
    }

    /**
     *    todo[17]电话号码的字母组合
     */
    @Test
    public void letterCombinationsTest(){
        SequenceMethod1 sequenceMethod = new SequenceMethod1();
        System.out.println(sequenceMethod.letterCombinations("23"));
    }

    /**
     *    [18]四数之和
     */
    @Test
    public void fourSumTest(){
        SequenceMethod1 sequenceMethod = new SequenceMethod1();
        System.out.println(sequenceMethod.fourSum(new int[]{1,0,-1,0,-2,2},0));
    }












    /**
     *    [39]组合总和
     */
    @Test
    public void combinationSumTest(){
        SequenceMethod1 sequenceMethod = new SequenceMethod1();
        System.out.println(sequenceMethod.combinationSum(new int[]{2,2,3,7},7));
    }


    /**
     *    [15]三数之和
     */
    @Test
    public void combinationSum3Test(){
        SequenceMethod1 sequenceMethod = new SequenceMethod1();
        System.out.println(sequenceMethod.combinationSum3(3,7));
    }




}
