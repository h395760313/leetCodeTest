package com.structure._7_映射;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xiehongyu
 * @date 2021/11/25 17:02
 */
public class TreeMap<K, V> implements Map<K, V>{

    private final static boolean RED = false;
    private final static boolean BLACK = true;

    private int size;
    private Node<K, V> root;
    private Comparator<K> comparator;

    public TreeMap() {
        this(null);
    }

    public TreeMap(Comparator<K> comparator) {
        this.comparator = comparator;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public V put(K key, V value) {
        elementNotNullCheck(key);
        // 添加第一个节点
        if (root == null) {
            root = createNode(key, value, null);
            size++;
            afterPut(root);
            return null;
        }

        //先找到父节点
        Node<K, V> parent = root;
        Node<K, V> node = root;
        int cmp = 0;
        while (node != null) {
            cmp = compare(key, node.key);
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
        }

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
        Node<K, V> node = node(key);
        return node != null ? node.value : null;
    }

    @Override
    public V remove(K key) {
        return remove(node(key));
    }
    
    @Override
    public boolean containsKey(K key) {
        return node(key) != null;
    }

    @Override
    public boolean containsValue(V value) {
        if (root == null) return false;
        Queue<Node<K, V>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<K, V> node = queue.poll();
            if (valEquals(node.value, value)) return true;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return false;
    }

    @Override
    public void traversal(Visitor visitor) {
        if (visitor == null || visitor.stop) return;
        traversal(root, visitor);
    }

    private void traversal(Node<K,V> node, Visitor visitor) {
        if (node == null) return;
        traversal(node.left, visitor);
        if (visitor.stop) return;
        visitor.visit(node.key, node.value);
        traversal(node.right, visitor);
    }

    private void elementNotNullCheck(K key) {
        if (key == null) {
            throw new RuntimeException("key must not be null");
        }
    }

    private V remove(Node<K,V> node) {
        if (node == null) return null;
        size--;

        V oldValue = node.value;
        if (node.hasTwoChildren()) { // 度为2的节点
            // 找到前驱或者后继节点
            Node<K, V> predecessor = getPredecessor(node);
            node.key = predecessor.key; // 用前驱节点的值覆盖需要删除的节点的值
            node.value = predecessor.value; // 用前驱节点的值覆盖需要删除的节点的值
            node = predecessor; // 只需要删除前驱节点即可
        }

        // 删除度为1或者0的节点
        Node<K, V> replaceNode = node.right == null ? node.left : node.right;
        if (replaceNode != null) { // 表示被删除节点的度为1
            replaceNode.parent = node.parent; // 设置替换者的parent为被删除节点的parent
            if (node.parent == null) { // 表示被删除节点是度为1的根节点
                root = replaceNode;
            } else if (node == node.parent.left) { // 表示被删除节点是度为1的parent的左子节点
                node.parent.left = replaceNode;
            } else { // node == node.parents.right 表示被删除节点是度为1的parent的右子节点
                node.parent.right = replaceNode;
            }
            // 删除节点后的处理
            afterRemove(replaceNode);
        } else if (node.parent == null) { // 表示叶子节点并且是根节点
            root = null;
            // 删除节点后的处理
            afterRemove(node);
        } else {
            if (node == node.parent.left) { // 表示叶子节点并且是左子节点
                node.parent.left = replaceNode;
            } else { // node == node.parents.right 表示叶子节点并且是右子节点
                node.parent.right = replaceNode;
            }
            // 删除节点后的处理
            afterRemove(node);
        }
        return oldValue;
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

    private void afterRemove(Node<K, V> node) {
        // 如果删除的节点是红色
        // 或者如果用以取代被删除节点的子节点是红色
        if (isRed(node)) {
            black(node);
            return;
        }

        Node<K, V> parent = node.parent;
        // 如果删除的是根节点
        if (parent == null) return;

        // 如果被删除的节点是黑色叶子节点
        // 被删除节点是左还是右
        boolean left = (parent.left == null || node.isLeftChild());
        Node<K, V> sibling = left ? parent.right : parent.left;

        if (left) { // 被删除节点在左边，兄弟节点在右边
            if (isRed(sibling)) {
                // 兄弟节点是红色
                black(sibling);
                red(parent);
                rotateLeft(parent);
                sibling = parent.right;
            }

            // 兄弟节点是黑色
            if (isBlack(sibling.left) && isBlack(sibling.right)) {
                //兄弟节点没有红色子节点，父节点向下合并
                boolean parentBlack = isBlack(parent);
                black(parent);
                red(sibling);
                if (parentBlack) {
                    afterRemove(parent);
                }
            } else {
                // 兄弟节点至少有一个红色子节点
                // 兄弟节点左边为黑色，先旋转
                if (isBlack(sibling.right)) {
                    rotateRight(sibling);
                    sibling = parent.right;
                }
                color(sibling, colorOf(parent));
                black(sibling.right);
                black(parent);
                rotateLeft(parent);
            }
        } else { // 被删除节点在右边，兄弟节点在左边
            if (isRed(sibling)) {
                // 兄弟节点是红色
                black(sibling);
                red(parent);
                rotateRight(parent);
                sibling = parent.left;
            }

            // 兄弟节点是黑色
            if (isBlack(sibling.left) && isBlack(sibling.right)) {
                //兄弟节点没有红色子节点，父节点向下合并
                boolean parentBlack = isBlack(parent);
                black(parent);
                red(sibling);
                if (parentBlack) {
                    afterRemove(parent);
                }
            } else {
                // 兄弟节点至少有一个红色子节点
                // 兄弟节点左边为黑色，先旋转
                if (isBlack(sibling.left)) {
                    rotateLeft(sibling);
                    sibling = parent.left;
                }
                color(sibling, colorOf(parent));
                black(sibling.left);
                black(parent);
                rotateRight(parent);
            }
        }

    }

    /**
     * 前驱节点
     * @param node
     * @return
     */
    private Node<K, V> getPredecessor(Node<K, V> node){
        // 左节点不为空 node = left.right.right.right.....
        Node<K, V> pre = node.left;
        if (pre != null) {
            while (pre.right != null){
                pre = pre.right;
            }
            return pre;
        }

        // 从祖父节点找前驱节点 node = parents.parents.parents... 直到节点为父节点的右节点停止
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }
        return node.parent;
    }

    /**
     * 后驱节点
     * @param node
     * @return
     */
    private Node<K, V> getPostdecessor(Node<K, V> node){
        // 左节点不为空 node = right.left.left.left.....
        Node<K, V> post = node.right;
        if (post != null) {
            while (post.left != null){
                post = post.left;
            }
            return post;
        }

        // 从祖父节点找前驱节点 node = parents.parents.parents... 直到节点为父节点的左节点停止
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return node.parent;
    }

    private Node<K, V> createNode(K key, V value, Node<K, V> parent){
        return new Node<>(key, value, parent);
    }

    private void afterRotate(Node<K, V> grand, Node<K, V> parent, Node<K, V> child){
        // 将parent成为子树的根节点
        parent.parent = grand.parent;
        if (grand.isLeftChild()) {
            grand.parent.left = parent;
        } else if (grand.isRightChild()) {
            grand.parent.right = parent;
        } else {
            root = parent;
        }

        // 更新child的parent
        if (child != null) {
            child.parent = grand;
        }

        // 更新grand的parent
        grand.parent = parent;
    }

    private Node<K, V> node(K key) {
        Node<K, V> node = root;
        while (node != null) {
            if (compare(key, node.key) == 0) {
                return node;
            } else if (compare(key, node.key) > 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return null;
    }

    private int compare(K k1, K k2) {
        if (comparator != null) {
            return comparator.compare(k1, k2);
        }
        return ((Comparable<K>) k1).compareTo(k2);
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

    private void rotate(Node<K, V> r,
                          Node<K, V> b, Node<K, V> c,
                          Node<K, V> d,
                          Node<K, V> e, Node<K, V> f) {
        // 让d成为这棵子树的根节点
        d.parent = r.parent;
        if (r.isLeftChild()) {
            r.parent.left = d;
        } else if (r.isRightChild()) {
            r.parent.right = d;
        } else {
            root = d;
        }

        // b-c
        b.right = c;
        if (c != null) {
            c.parent = b;
        }

        // e-f
        f.left = e;
        if (e != null) {
            e.parent = f;
        }
        // b-d-f
        d.left = b;
        d.right = f;
        b.parent = d;
        f.parent = d;
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

    private boolean valEquals(V v1, V v2) {
        return v1 == null ? v2 == null : v1.equals(v2);
    }

    private static class Node<K, V> {
        boolean color = RED;
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
