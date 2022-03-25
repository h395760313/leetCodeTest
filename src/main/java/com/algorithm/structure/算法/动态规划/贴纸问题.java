package com.algorithm.structure.算法.动态规划;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description todo
 * @Author: x
 */
public class 贴纸问题 {

    public static int ways1(String[] t, String target){
        int n = t.length;
        if (n == 0 || target.isEmpty()) return 0;

        int[][] map = new int[n][26];
        for (int i = 0; i < n; i++) {
            for (char c : t[i].toCharArray()) {
                map[i][(c - 'a')]++;
            }
        }
        Map<String, Integer> dp = new HashMap<>();
        dp.put("",0);
        return process1(map, target, dp);
    }

    private static int process1(int[][] map, String rest, Map<String, Integer> dp) {
        if (dp.containsKey(rest)) {
            return dp.get(rest);
        }
        int ans = Integer.MAX_VALUE;
        int[] tmap = new int[26];
        char[] target = rest.toCharArray();
        for (char c : target) {
            tmap[(c - 'a')]++;
        }
        for (int i = 0; i < map.length; i++) {

            // 加速
            if (map[i][target[0] - 'a'] == 0) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (tmap[j] > 0) {
                    for (int k = 0; k < Math.max(0, tmap[j] - map[i][j]); k++) {
                        sb.append((char)(j + 'a'));
                    }
                }
            }
            String str = sb.toString();
            if (str.equals(rest)) continue;
            int ways = process1(map, str, dp);
            if (ways != -1) {
                ans = Math.min(ways + 1, ans);
            }
        }
        dp.put(rest, ans == Integer.MAX_VALUE ? -1 : ans);
        return dp.get(rest);
    }

    public static int ways2(String[] t, String target){
        int n = t.length;
        if (n == 0 || target.isEmpty()) return 0;

        int[][] map = new int[n][26];
        for (int i = 0; i < n; i++) {
            for (char c : t[i].toCharArray()) {
                map[i][(c - 'a')]++;
            }
        }
        Map<String, Integer> dp = new HashMap<>();
        dp.put("",0);
        return process1(map, target, dp);
    }

    public static void main(String[] args) {
        String[] t = new String[]{"aass","ssdd","ddff","ffgg","gghh","hhjj","jjkk","kkll","asdf","ghjk","sdfg","hjkl"};
        String target = "adfahsgfhkjaggljajhklsahgjshsjdkahsdjklfsdahjlfasdhgjasgflgsdasgadhjlkfdashjklfadshljkafsdghlkjgalhfjkgasfhljksadfghsafdghsfadghlsaghjflkgfhjgfashjlasghljasgdhljsagdhgsadhjsadgfhdsfaghlfajhglkjahgljhshfdgaksfgklsahfaskgjlaghljkahglkashdfkljagsdflkasagfkajhsfkshdgjkasdfkjah"; // 3
        long start = System.currentTimeMillis();
        System.out.println(ways1(t, target));
        System.out.println(System.currentTimeMillis() - start);
//        start = System.currentTimeMillis();
//        System.out.println(ways1(t, target));
//        System.out.println(System.currentTimeMillis() - start);
    }
}
