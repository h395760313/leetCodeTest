package com.algorithm.structure.算法.kmp;


/**
 * @author xiehongyu
 * @date 2022/02/18 17:24
 */
public class KMP {

    public static void main(String[] args) {
        String str1 = "sgdshfgshsgFsfsdfasabbtabbecabbtabbfsgafagfasfasdfsadfasf";
        String str2 = "abbtabbecabbtabbf";
        // -1 0 0
        System.out.println(kmp(str1, str2));
    }

    private static int[] getNextArr(String str){
        int[] next = new int[str.length()];

        next[0] = -1;
        next[1] = 0;

        for (int i = 2; i < next.length; i++) {
            int index = next[i - 1];
            while (index >= 0) {
                if (str.charAt(i) == str.charAt(index)) {
                    next[i] = index + 1;
                    break;
                } else if (index == 0) {
                    next[i] = str.charAt(i) == str.charAt(index) ? 1 : 0;
                    break;
                }else {
                    index = next[index - 1];
                }
            }
        }
        return next;
    }

    private static int kmp(String str1, String str2){
        if (str1.length() < str2.length()){
            return -1;
        }
        int[] nextArr = getNextArr(str2);

        int i1 = 0;
        int i2 = 0;
        while (i1 < str1.length() && i2 < str2.length()) {
            if (str1.charAt(i1) == str2.charAt(i2)) {
                i1++;
                i2++;
            }else if (nextArr[i2] == -1) {
                i1++;
            }else {
                i2 = nextArr[i2];
            }
        }
        return i2 == str2.length() ? i1 - i2 : -1;
    }
}
