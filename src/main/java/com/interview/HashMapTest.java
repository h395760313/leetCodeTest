package com.interview;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    @Test
    public void Test01() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("hollis1","hollischuang");
        map.put("hollis2","hollischuang");
        map.put("hollis3","hollischuang");
        map.put("hollis4","hollischuang");
        map.put("hollis5","hollischuang");
        map.put("hollis6","hollischuang");
        map.put("hollis7","hollischuang");
        map.put("hollis8","hollischuang");
        map.put("hollis9","hollischuang");
        map.put("hollis10","hollischuang");
        print(map);
        map.put("hollis11","hollischuang");
        print(map);
        map.put("hollis12","hollischuang");
        print(map);
        map.put("hollis13","hollischuang");
        print(map);
        map.put("hollis14","hollischuang");
        print(map);
        map.put("hollis15","hollischuang");
        print(map);
        map.put("hollis16","hollischuang");
        print(map);
        map.put("hollis17","hollischuang");
        print(map);

    }

    private void print(Map<String, String> map) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        System.out.println("@@@@@@@@@@=======@@@@@@@@@@");
        Class<? extends Map> mapType = map.getClass();
        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity: "+ capacity.invoke(map));
        Field size = mapType.getDeclaredField("size");
        size.setAccessible(true);
        System.out.println("size = " + size.get(map));
        System.out.println("@@@@@@@@@@=======@@@@@@@@@@");

    }
}
