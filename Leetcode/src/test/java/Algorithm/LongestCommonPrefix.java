package Algorithm;

//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
// 示例 1:
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
//
//
// 示例 2:
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
//
//
// 说明:
//
// 所有输入只包含小写字母 a-z 。
// Related Topics 字符串
// 👍 1313 👎 0

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{"cir", "car"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        int minLen = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minLen) {
                minLen = strs[i].length();
            }
        }
        String str = "";
        char[] b = strs[0].toCharArray();
        for (int j = 0; j < minLen; j++) {

            int count = 0;
            String s = "";
            s += b[j];

            for (int i = 1; i < strs.length; i++) {

                if (strs[i].toCharArray()[j] == b[j]) {
                    count++;
                }
            }
            if (count == strs.length - 1) {
                str += s;
            } else break;
        }
        return str;
    }
}
