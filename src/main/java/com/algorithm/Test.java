package com.algorithm;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        try {
            ArrayList<Integer> list = new ArrayList<Integer>(10);
            int a = list.get(1);
        } catch (Exception e) {
            System.out.println("e.getLocalizedMessage() = " + e.getLocalizedMessage());

        }

    }


}
