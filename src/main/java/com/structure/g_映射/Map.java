package com.structure.g_映射;

/**
 * @author xiehongyu
 * @date 2021年11月24日 14:19
 */
public interface Map<K, V> {

    int size();
    boolean isEmpty();
    void clear();
    V put(K key, V value);
    V get(K key);
    V remove(K key);
    boolean containsKey(K key);
    boolean containsValue(V value);
    void traversal(Visitor visitor);

    abstract class Visitor<K, V>{
        boolean stop;
        /**
         *  返回false则退出遍历
         */
        public abstract boolean visit(K key, V value);
    }
}
