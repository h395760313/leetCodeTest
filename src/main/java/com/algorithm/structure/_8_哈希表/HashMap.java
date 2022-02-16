package com.algorithm.structure._8_哈希表;


import java.util.Objects;

/**
 * @author xiehongyu
 * @date 2021/12/03 11:04
 */
public class HashMap<K, V> implements Map<K, V>{


    private final static boolean RED = false;
    private final static boolean BLACK = true;
    private final static int DEFAULT_CAPACITY = 1 << 4;
    private int size;
    private Node<K, V>[] table;


    public HashMap() {
        table = new Node[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        if (size == 0) return;
        size = 0;
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
    }

    @Override
    public V put(K key, V value) {
        int index = index(key);
        Node<K, V> root = table[index];
        
        // 红黑树根节点为空 
        if (root == null) {
            root = new Node<>(key, value, null);
            table[index] = root;
            size ++;
            afterPut(root);
            return null;
        }
        
        // 根节点不为空
        Node<K, V> parent = root;
        Node<K, V> node = root;
        int cmp = 0;
        int h1 = key.hashCode();
        do {
            cmp = compare(key, node.key, h1, node.hash);
            parent = node;
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else {
                node.key = key;
                V oldValue = value;
                node.value = value;
                return oldValue;
            }
        }while (node != null);

            // 看看插入到父节点的哪个位置
        Node<K, V> newNode = createNode(key, value, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
        afterPut(newNode);
        return null;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        return false;
    }

    @Override
    public void traversal(Visitor visitor) {

    }

    /**
     * 获取key在table中该存放的索引值
     * @param key
     * @return
     */
    private int index(K key) {
        // hashMap 的 key允许为空
        if (key == null) return 0;

        int hash = key.hashCode();
        return (hash ^ (hash >>> 16)) & (table.length - 1);
    }

    private int compare(K k1, K k2, int h1, int h2) {
        // hash值是否相同
        int result = h1 - h2;
        if (result != 0) return result;

        // hash冲突 判断equals
        if (Objects.equals(k1, k2)) return 0;

        // hashcode相同 但not equals
        // 比较类名
        if (k1 != null && k2 != null) {
            String k1Clz = k1.getClass().getName();
            String k2Clz = k2.getClass().getName();
            result = k1Clz.compareTo(k2Clz);
            if (result != 0) return result;

            // 同一种类型 判断是否具备可比较性
            if (k1 instanceof Comparable) {
                return ((Comparable<K>) k1).compareTo(k2);
            }
        }
        return System.identityHashCode(k1) - System.identityHashCode(k2);
    }

    private Node<K, V> createNode(K key, V value, Node<K, V> parent){
        return new Node<>(key, value, parent);
    }

    private void afterPut(Node<K, V> node){
        Node<K, V> parent = node.parent;

        // 添加的是根节点
        if (null == parent) {
            black(node);
            return;
        }

        // 如果父节点是黑色，直接返回
        if (isBlack(parent)) return;

        // 叔父节点
        Node<K, V> uncle = parent.sibling();
        // 祖父节点
        Node<K, V> grand = parent.parent;

        // 叔父节点是红色
        if (isRed(uncle)) {
            black(uncle);
            black(parent);
            // 把祖父节点当作新添加的新节点
            red(grand);
            afterPut(grand);
        }else {
            red(grand);
            if (parent.isLeftChild()) { // L
                if (node.isLeftChild()) {
                    // LL
                    // 染色：父节点染黑，祖父节点染红
                    // 旋转：祖父节点右旋转
                    black(parent);
                }else {
                    // LR
                    // 染色：新增节点染黑，祖父节点染红
                    // 旋转：父节点左旋转，祖父节点右旋转
                    black(node);
                    rotateLeft(parent);
                }
                rotateRight(grand);
            }else { // R
                if (node.isLeftChild()) {
                    // RL
                    // 染色：新增节点染黑，祖父节点染红；
                    // 旋转：父节点右旋转，祖父节点左旋转
                    black(node);
                    rotateRight(parent);
                }else {
                    // RR
                    // 染色：父节点染黑，祖父节点染红
                    // 旋转：祖父节点左旋转
                    black(parent);
                }
                rotateLeft(grand);
            }
        }
    }

    /**
     * 将节点左旋转
     *
     * @param grand
     */
    private void rotateLeft(Node<K, V> grand) {
        Node<K, V> parent = grand.right;
        Node<K, V> child = parent.left;
        grand.right = child;
        parent.left = grand;
        // 维护parent
        afterRotate(grand, parent, child);
    }

    /**
     * 将节点右旋转
     *
     * @param grand
     */
    private void rotateRight(Node<K, V> grand) {
        Node<K, V> parent = grand.left;
        Node<K, V> child = parent.right;
        grand.left = parent.right;
        parent.right = grand;
        // 维护parent
        afterRotate(grand, parent, child);
    }

    private void afterRotate(Node<K, V> grand, Node<K, V> parent, Node<K, V> child){
        // 将parent成为子树的根节点
        parent.parent = grand.parent;
        if (grand.isLeftChild()) {
            grand.parent.left = parent;
        } else if (grand.isRightChild()) {
            grand.parent.right = parent;
        } else {
            table[index(grand.key)] = parent;
        }

        // 更新child的parent
        if (child != null) {
            child.parent = grand;
        }

        // 更新grand的parent
        grand.parent = parent;
    }


    private Node<K, V> color(Node<K, V> node, boolean color){
        if (node == null) return node;
        node.color = color;
        return node;
    }

    private Node<K, V> red(Node<K, V> node){
        return color(node,RED);
    }

    private Node<K, V> black(Node<K, V> node){
        return color(node,BLACK);
    }

    private boolean colorOf(Node<K, V> node){
        return node == null ? BLACK : node.color;
    }

    private boolean isRed(Node<K, V> node){
        return colorOf(node) == RED;
    }

    private boolean isBlack(Node<K, V> node){
        return colorOf(node) == BLACK;
    }


    private static class Node<K, V> {
        boolean color = RED;
        int hash;
        K key;
        V value;
        Node<K, V> left;
        Node<K, V> right;
        Node<K, V> parent;
        public Node(K key, V value, Node<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean hasTwoChildren() {
            return left != null && right != null;
        }

        public boolean isLeftChild() {
            return parent != null && this == parent.left;
        }

        public boolean isRightChild() {
            return parent != null && this == parent.right;
        }

        public Node<K, V> sibling() {
            if (isLeftChild()) {
                return parent.right;
            }
            if (isRightChild()) {
                return parent.left;
            }
            return null;
        }

    }
}
