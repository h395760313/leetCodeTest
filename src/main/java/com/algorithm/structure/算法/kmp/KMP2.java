package com.algorithm.structure.算法.kmp;


/**
 * @author xiehongyu
 * @date 2022/02/18 17:24
 */
public class KMP2 {

    public static void main(String[] args) {
        String str1 = "sgdshfgshsgFsfsdfasabbtabbecabbtabbfsgafagfasfasdfsadfasf";
        String str2 = "abbtabbecabbtabbf";

        System.out.println(kmp(str1, str2));
    }


    private static int kmp(String str1, String str2){
        if (str1.length() < str2.length()) return -1;
        int[] next = buildNextArr(str2);
        int i1 = 0, i2 = 0;
        while (i1 < str1.length() && i2 < str2.length()) {
            if (str1.charAt(i1) == str2.charAt(i2)) {
                i1++;
                i2++;
            }else if (i2 == 0) {
                i1++;
            }else {
                i2 = next[i2];
            }
        }
        return i2 == str2.length() ? i1 - i2 : -1;
    }

    /**
     * 构建next数组，保存每个位置之前的字符串的前缀和后缀相同的字符数
     * @param str2
     * @return
     */
    private static int[] buildNextArr(String str2) {
        int[] next = new int[str2.length()];
        next[0] = -1;
        next[1] = 0;

        for (int i = 2; i < str2.length(); i++) {
            int index = next[i - 1];
            while (index >= 0) {
                if (str2.charAt(index) == str2.charAt(i)) {
                    next[i] += index;
                    break;
                }else if (index == 0){
                    next[i] = 0;
                    break;
                }else {
                    index = next[index];
                }
            }

        }
        return next;
    }
}
