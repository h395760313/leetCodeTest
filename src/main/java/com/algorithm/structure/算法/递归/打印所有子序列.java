package com.algorithm.structure.算法.递归;



import java.util.*;

/**
 * @author xiehongyu
 * @date 2022-03-20
 */
public class 打印所有子序列 {

    public static List<String> sub(String str){
        List<String> ans = new ArrayList<>();
        process1(str.toCharArray(), 0, ans, "");
        ans.sort((o1, o2) -> {
            int index = 0, len1 = o1.length(), len2 = o2.length();
            while (index < len1 && index < len2) {
                if (o1.charAt(index) == o2.charAt(index)) {
                    index++;
                    continue;
                }else if (o1.charAt(index) < o2.charAt(index)) {
                    return -1;
                }else {
                    return 1;
                }
            }
            if (index == len1) {
                return -1;
            }else {
                return 1;
            }
        });
        return ans;
    }

    public static void process1(char[] str, int index, List<String> ans, String path){
        if (index == str.length) {
            ans.add(path);
            return;
        }
        String no = path;
        process1(str, index+1, ans, no);
        String yes = path + str[index];
        process1(str, index+1, ans, yes);
    }

    public static List<String> subNoRepeat(String str){
        Set<String> ans = new TreeSet<>();
        process2(str.toCharArray(), 0, ans, "");
        List<String> res = new ArrayList<>();
        for (String an : ans) {
            res.add(an);
        }
        return res;
    }

    public static void process2(char[] str, int index, Set<String> ans, String path){
        if (index == str.length) {
            ans.add(path);
            return;
        }
        String no = path;
        process2(str, index+1, ans, no);
        String yes = path + str[index];
        process2(str, index+1, ans, yes);
    }

    public static void main(String[] args) {
        List<String> sub = sub("aabcd");
        List<String> subNoRepeat = subNoRepeat("aabcd");

        System.out.println(sub.size());
        for (String an : sub) {
            System.out.println(an);
        }

        System.out.println(subNoRepeat.size());
        for (String an : subNoRepeat) {
            System.out.println(an);
        }
    }
}


