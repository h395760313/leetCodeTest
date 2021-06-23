package com.algorithm.array.a_1_easy;

/*给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

 你可以假设除了整数 0 之外，这个整数不会以零开头。

 示例 1:

 输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。


 示例 2:
R
 输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。

 Related Topics 数组
 👍 570 👎 0*/
public class PlusOne {

    public static void main(String[] args) {
        int[] ints = plusOne(new int[]{3, 9, 9});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] plusOne(int[] digits) {
        if (digits == null) {
            return null;
        }
        int[] arr = new int[digits.length + 1];
        boolean flag = false;
        digits[digits.length - 1] = digits[digits.length - 1] + 1;
        if (digits[digits.length - 1] != 10) {
            return digits;
        }
        digits[digits.length - 1] = 0;
        arr[arr.length - 1] = 0;
        flag = true;

        for (int i = digits.length - 2; i >= 0; i--) {
            if (flag) {
                arr[i + 1] = digits[i] + 1;
                digits[i] = digits[i] + 1;
                if (arr[i + 1] != 10) {
                    return digits;
                }
                digits[i] = 0;
                arr[i + 1] = 0;
                flag = true;
            }
        }
        if (flag) {
            arr[0] = 1;
        }
        return arr;
    }
}