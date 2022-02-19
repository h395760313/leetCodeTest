package com.algorithm.leetCode._28_实现strStr;

import com.algorithm.leetCode.common.ListNode;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author xiehongyu
 * @date 2022/02/19 10:57
 */
public class _28_实现strStr {

    public int strStr(String haystack, String needle) {

//        执行耗时:1757 ms,击败了6.18% 的Java用户
//        内存消耗:41.1 MB,击败了7.25% 的Java用户
        /** 暴力循环 一个一个匹配
         int nLen = needle.length();
         int hLen = haystack.length();
         if(needle.isEmpty()) return 0;
         if(nLen > hLen) return -1;
         for(int i = 0; i < hLen - nLen + 1; i++) {
         int j;
         for(j = 0; j < nLen; j++) {
         if(haystack.charAt(i + j) != needle.charAt(j)) break;
         if(j == nLen - 1) return i;
         }
         }
         return -1;*/


//		执行耗时:1296 ms,击败了26.61% 的Java用户
//		内存消耗:41.1 MB,击败了7.22% 的Java用户
        /** 暴力循环-优化
         int nLen = needle.length();
         int hLen = haystack.length();
         if(needle.isEmpty()) return 0;
         if(nLen > hLen) return -1;
         for(int i = 0; i < hLen - nLen + 1; i++) {
         int j;
         for(j = 0; j < nLen; j++) {
         if(haystack.charAt(i + j) != needle.charAt(j)) break;
         }
         if(j == nLen) return i;
         }
         return -1;*/

//
//        执行耗时:1321 ms,击败了23.70% 的Java用户
//        内存消耗:41.4 MB,击败了5.02% 的Java用户
        /** BF算法
         int i,j;
         int nLen = needle.length();
         int hLen = haystack.length();
         if (nLen == 0) return nLen;
         for (i = 0, j = 0; i < hLen && j < nLen; i++) {
         if (haystack.charAt(i) == needle.charAt(j)) {
         j++;
         }else {
         i -= j;
         j = 0;
         }
         }
         return j == nLen ? i - nLen : -1;*/


        /** BM算法
         *
         */
        char[] hay = haystack.toCharArray();
        char[] need = needle.toCharArray();
        int haylen = hay.length;
        int needlen = need.length;
        return bm(hay, haylen, need, needlen);
    }

    // 用来求坏字符情况下移动的位数
    private static void badChar(char[] b, int m, int[] bc) {
        // 初始化
        Arrays.fill(bc, -1);

        // m代表模式串的长度，如果有两个a，则后面那个会覆盖前面那个
        for (int i = 0; i < m; ++i) {
            int ascii = b[i];
            bc[ascii] = i; // 下标
        }
    }

    // 用来求好后缀条件下的移动位数
    private static void goodSuffix(char[] b, int m, int[] suffix, boolean[] prefix) {
        // 初始化
        Arrays.fill(suffix, -1);
        Arrays.fill(prefix, false);

        for (int i = 0; i < m - 1; ++i) {
            int j = i;
            int k = 0;
            while (j >= 0 && b[j] == b[m - 1 - k]) {
                --j;
                ++k;
                suffix[k] = j + 1;
            }
            if (j == -1) prefix[k] = true;
        }
    }

    private static int bm(char[] a, int n, char[] b, int m) {
        int[] bc = new int[256]; //创建一个整数数组来保存最右边字符的下标
        badChar(b, m, bc);
        // 用来保存各种长度好后缀的最右位置的数组
        int[] sufix_index = new int[m];
        // 判断是否是头部，如果是头部则为true
        boolean[] ispre = new boolean[m];
        goodSuffix(b, m, sufix_index, ispre);
        int i = 0; // 第一个匹配字符
        // 注意结束条件
        while (i <= n - m) {
            int j;
            // 从后往前匹配，匹配失败，找到坏字符
            for (j = m - 1; j >= 0; --j) {
                if (a[i + j] != b[j]) break;
            }
            // 模式串遍历完毕，匹配成功
            if (j < 0) {
                return i;
            }
            // 下面为匹配失败时，如果处理
            // 求出坏字符规则下移动的位数，就是我们坏字符下标减最右边的下标
            int x = j - bc[(int) a[i + j]];
            int y = 0;
            // 好后缀情况，求出好后缀情况下的移动位数，如果不含有好后缀的话，则按照坏字符来
            if (y < m - 1 && m - 1 - j > 0) {
                y = move(j, m, sufix_index, ispre);
            }
            // 移动
            i = i + Math.max(x, y);
        }
        return -1;
    }

    // j代表坏字符的下标
    private static int move(int j, int m, int[] sufix_index, boolean[] ispre) {
        // 好后缀长度
        int k = m - 1 - j;
        // 如果含有长度为k的好后缀，返回移动位数
        if (sufix_index[k] != -1) return j - sufix_index[k] + 1;
        // 找头部为好后缀子串的最大长度，从长度最大的子串开始
        for (int r = j + 2; r <= m - 1; ++r) {
            // 如果是头部
            if (ispre[m - r]) {
                return r;
            }
        }
        // 如果没有发现好后缀匹配的串，或者头部为好后缀子串，则移动到m为，也就是匹配串的长度
        return m;
    }

    @Test
    public void test() {
        String str1 = "aabaaabaaac";
        String str2 = "aabaaac";

        System.out.println(kmp(str1, str2));
    }

    private int kmp(String haystack, String needle){
        if (haystack == null || needle == null || haystack.length() < needle.length()) return -1;
        if (needle.length() < 1) return 0;
        int[] next = buildNextArray(needle);
        int i1 = 0, i2 = 0;
        while (i1 < haystack.length() && i2 < needle.length()) {
            if (haystack.charAt(i1) == needle.charAt(i2)) {
                i1++;
                i2++;
            }else if (i2 == 0) {
                i1++;
            }else {
                i2 = next[i2];
            }
        }
        return i2 == needle.length() ? i1 - i2 : -1;
    }

    private int[] buildNextArray(String str) {
        if (str.length() < 1) return new int[]{-1};
        int[] next = new int[str.length()];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < str.length()) {
            if (str.charAt(i - 1) == str.charAt(cn)) {
                next[i++] = ++cn;
            }else if (cn == 0) {
                next[i++] = 0;
            }else {
                cn = next[cn];
            }
        }
        return next;
    }
}
