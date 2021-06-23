package com.algorithm.array.a_1_easy;

import java.util.ArrayList;
import java.util.List;

/*给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。



 在杨辉三角中，每个数是它左上方和右上方的数的和。

 示例:

 输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 Related Topics 数组 */

public class PascalTriangles {
    public static void main(String[] args) {
        int numRows = 5;
        int length = 1;
        List<List<Integer>> bigList = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        bigList.add(list);
        System.out.println(pascalTriangles1(numRows, length, list, bigList));

    }

    public static List<List<Integer>> pascalTriangles(int numRows) {

        return null;
    }

    public static List pascalTriangles1(int numRows, int length, List<Integer> list, List<List<Integer>> bigList) {

        length++;

        if (length > numRows) {
            return bigList;
        }
        List<Integer> newList = new ArrayList<Integer>(length);
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                newList.add(list.get(0));
            } else if (i > 2) {
                newList.add(list.get(i - 1) + list.get(i));
            } else if (i == list.size() - 1) {
                newList.add(list.get(list.size() - 1));
            }
        }
        bigList.add(list);
        return pascalTriangles1(numRows, length, newList, bigList);
    }
}
