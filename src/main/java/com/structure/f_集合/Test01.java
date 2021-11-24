package com.structure.f_集合;

import org.junit.Test;

/**
 * @author xiehongyu
 * @date 2021年11月24日 14:31
 */
public class Test01 {

    @Test
    public void test01(){
//        Set<Integer> set = new ListSet<>();
//        set.add(11);
//        set.add(11);
//        set.add(12);
//        set.add(10);
//        set.add(10);


        Set<Integer> set = new TreeSet<>();
        set.add(12);
        set.add(11);
        set.add(11);
        set.add(10);
        set.add(10);

        set.traversal(new Set.Visitor() {
            public boolean visit(Object element) {
                System.out.println(element);
                return false;
            }
        });
    }
}
