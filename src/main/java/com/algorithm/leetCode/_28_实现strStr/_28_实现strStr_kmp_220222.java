package com.algorithm.leetCode._28_实现strStr;

import org.junit.Test;

/**
 * @author xiehongyu
 * @date 2022/02/19 10:57
 */
public class _28_实现strStr_kmp_220222 {

    public int strStr(String haystack, String needle) {
        int hlen = haystack.length();
        int nlen = needle.length();
        if (haystack == null || needle == null || hlen < nlen) return -1;
        if (nlen < 1) return 0;

        int[] next = buildNextArray(needle);
        int i1 = 0, i2 = 0;
        while (i1 < hlen && i2 < nlen) {
            if (haystack.charAt(i1) == needle.charAt(i2)) {
                i1++;i2++;
            }else if (next[i2] == -1) {
                i1++;
            }else {
                i2 = next[i2];
            }
        }
        return i2 == nlen ? i1 - i2 : -1;
    }

    private int[] buildNextArray(String needle) {
        if (needle.length() == 1) return new int[]{-1};
        int[] next = new int[needle.length()];
        next[0] = -1;
        next[1] = 0;
        int i = 2, cn = 0;
        while (i < needle.length()) {
            if (needle.charAt(i - 1) == needle.charAt(cn)) {
                next[i++] = ++cn;
            }else if (cn == 0) {
                i++;
            }else {
                cn = next[cn];
            }
        }
        return next;
    }

    @Test
    public void test() {
        String str1 = "aabaaabaaac";
        String str2 = "aabaaac";

        System.out.println(strStr(str1, str2));
    }

}
