package com.algorithm.华为机试题;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumUtils {

    public static String toBinaryString(int num){
        List<Integer> list = new ArrayList<>();

        while (num > 0) {
            int mod = num % 2;
            list.add(mod);
            num = num >> 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }

        return sb.toString();
    }

    public static String toHexString(int num){
        Map<Integer, Character> map = new HashMap<>();
        map.put(0, '0');
        map.put(1, '1');
        map.put(2, '2');
        map.put(3, '3');
        map.put(4, '4');
        map.put(5, '5');
        map.put(6, '6');
        map.put(7, '7');
        map.put(8, '8');
        map.put(9, '9');
        map.put(10, 'a');
        map.put(11, 'b');
        map.put(12, 'c');
        map.put(13, 'd');
        map.put(14, 'e');
        map.put(15, 'f');
        List<Character> list = new ArrayList<>();

        while (num > 0) {
            int mod = num % 16;
            num = num >> 4;
            list.add(map.get(mod));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }

        return sb.toString();
    }
}
