package com.structure._e_树.a_二叉树;

import java.util.Comparator;

/**
 * @author xiehongyu
 * @date 2021年11月23日 15:46
 */
public class RBTree<E> extends BBST<E>{
    private final static boolean RED = false;
    private final static boolean BLACK = true;

    public RBTree() {
        this(null);
    }

    public RBTree(Comparator<E> comparator) {
        super(comparator);
    }

    @Override
    protected void afterAdd(Node<E> node) {
        Node<E> parent = node.parent;

        // 添加的是根节点
        if (null == parent) {
            black(node);
            return;
        }

        // 如果父节点是黑色，直接返回
        if (isBlack(parent)) return;

        // 叔父节点
        Node<E> uncle = parent.sibling();
        // 祖父节点
        Node<E> grand = parent.parent;

        // 叔父节点是红色
        if (isRed(uncle)) {
            black(uncle);
            black(parent);
            // 把祖父节点当作新添加的新节点
            red(grand);
            afterAdd(grand);
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

    @Override
    protected void afterRemove(Node<E> node) {
        // 如果删除的节点是红色
        // 或者如果用以取代被删除节点的子节点是红色
        if (isRed(node)) {
            black(node);
            return;
        }

        Node<E> parent = node.parent;
        // 如果删除的是根节点
        if (parent == null) return;

        // 如果被删除的节点是黑色叶子节点
        // 被删除节点是左还是右
        boolean left = (parent.left == null || node.isLeftChild());
        Node<E> sibling = left ? parent.right : parent.left;

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

    private Node<E> color(Node<E> node, boolean color){
        if (node == null) return node;
        ((RBNode<E>)node).color = color;
        return node;
    }

    private Node<E> red(Node<E> node){
        return color(node,RED);
    }

    private Node<E> black(Node<E> node){
        return color(node,BLACK);
    }

    private boolean colorOf(Node<E> node){
        return node == null ? BLACK : ((RBNode<E>)node).color;
    }

    private boolean isRed(Node<E> node){
        return colorOf(node) == RED;
    }

    private boolean isBlack(Node<E> node){
        return colorOf(node) == BLACK;
    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new RBNode<>(element, parent);
    }



    private static class RBNode<E> extends Node<E> {
        boolean color;

        public RBNode(E element, Node<E> parent) {
            super(element, parent);
        }

        @Override
        public String toString() {
            String str = "";
            if (color == RED) {
                str = "R_";
            }
            return str + element.toString();
        }
    }
}
