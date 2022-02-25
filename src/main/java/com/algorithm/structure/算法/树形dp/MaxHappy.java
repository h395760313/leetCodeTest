package com.algorithm.structure.算法.树形dp;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 求一个party中邀请员工参加所能获得的最大快乐值，要求：邀请一人后不能允许他的所有直接下级
 * @author xiehongyu
 * @date 2022/02/23 13:47
 */
public class MaxHappy {

    public static class Employee{
        int happy; // 员工的快乐值
        List<Employee> nexts; // 该员工的直接下级

        public Employee(int happy, List<Employee> nexts) {
            this.happy = happy;
            this.nexts = nexts;
        }
    }

    public static class Info{
        int laiMaxHappy;
        int buMaxHappy;

        public Info(int laiMaxHappy, int buMaxHappy) {
            this.laiMaxHappy = laiMaxHappy;
            this.buMaxHappy = buMaxHappy;
        }
    }

    public Info process(Employee x){
        if (x == null || x.nexts.isEmpty()) { // x为基层的时候
            return new Info(x.happy, 0);
        }
        int lai = x.happy;  // x来的情况下，整棵树的最大收益
        int bu = 0; // x不来的情况下，整棵树的最大收益
        for(Employee next: x.nexts) {
            Info nextInfo = process(next);
            lai += nextInfo.buMaxHappy;
            bu += Math.max(nextInfo.laiMaxHappy, nextInfo.buMaxHappy);
        }
        return new Info(lai,bu);
    }

    public int getPartyMaxHappy(Employee x) {
        return Math.max(process(x).laiMaxHappy, process(x).buMaxHappy);
    }

    @Test
    public void test(){

        Employee boss = new Employee(10, Arrays.asList(new Employee(3,Arrays.asList(new Employee(60,new ArrayList<>()))),new Employee(20,Arrays.asList(new Employee(3,new ArrayList<>()))),new Employee(40,Arrays.asList(new Employee(5,new ArrayList<>()),new Employee(6,new ArrayList<>())))));
        System.out.println(getPartyMaxHappy(boss));
    }
}
