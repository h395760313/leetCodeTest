package com.structure.e_二叉搜索树;

public enum OrderTypeEnum {

    Preorder(1,"PREORDER_TRAVERSAL"),
    inorder(2,"INORDER_TRAVERSAL"),
    postorder(3,"POSTORDER_TRAVERSAL"),
    levelorder(4,"LEVEL_ORDER_TRAVERSAL"),
    ;

    public int index;
    public String OrderType;

    OrderTypeEnum(int index, String orderType) {
        this.index = index;
        OrderType = orderType;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getOrderType() {
        return OrderType;
    }

    public void setOrderType(String orderType) {
        OrderType = orderType;
    }
}
