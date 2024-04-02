package com.leetcode.leftgod.union;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 并查集
 *
 * @author xiehongyu
 * @date 2024/4/2 18:44
 */
public class UnionFindSet<T> {
    public Map<T, Element> elementMap;
    public Map<Element, Element> fatherMap;
    public Map<Element, Integer> sizeMap;
    public UnionFindSet(List<T> list) {
        this.elementMap = new HashMap<>();
        this.fatherMap = new HashMap<>();
        this.sizeMap = new HashMap<>();
        for (T element : list) {
            Element E = new Element(element);
            elementMap.put(element, E);
            fatherMap.put(E, E);
            sizeMap.put(E, 1);
        }
    }

    public Element findHead(Element element) {
        Stack<Element> path = new Stack<>();
        while (element != fatherMap.get(element)) {
            path.push(element);
            element = fatherMap.get(element);
        }
        while (!path.isEmpty()) {
            fatherMap.put(path.pop(), element);
        }
        return element;
    }

    public boolean isSameSet(T x, T y) {
        if (elementMap.containsKey(x) && elementMap.containsKey(y)) {
            return findHead(elementMap.get(x)) == findHead(elementMap.get(y));
        }
        return false;
    }

    public void union(T x, T y) {
        if (elementMap.containsKey(x) && elementMap.containsKey(y)) {
            Element aF = findHead(elementMap.get(x));
            Element bF = findHead(elementMap.get(y));

            Element big = sizeMap.get(aF) >= sizeMap.get(bF) ? aF : bF;
            Element small = big == aF ? bF : aF;

            fatherMap.put(small, big);
            sizeMap.put(big, sizeMap.get(big) + sizeMap.get(small));
            sizeMap.remove(small);
        }
    }

    public class Element {
        public T value;

        public Element(T value) {
            this.value = value;
        }
    }

}
