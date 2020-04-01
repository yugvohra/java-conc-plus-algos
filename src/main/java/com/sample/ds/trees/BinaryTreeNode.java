package com.sample.ds.trees;

/**
 * Class represents a node of a binary tree
 * @param <T>
 */
public class BinaryTreeNode<T> {
    private T info;
    private BinaryTreeNode leftSon;
    private BinaryTreeNode rightSon;

    public BinaryTreeNode(T info, BinaryTreeNode leftSon, BinaryTreeNode rightSon) {


        this.info = info;
        this.leftSon = leftSon;
        this.rightSon = rightSon;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public BinaryTreeNode getLeftSon() {
        return leftSon;
    }

    public void setLeftSon(BinaryTreeNode leftSon) {
        this.leftSon = leftSon;
    }

    public BinaryTreeNode getRightSon() {
        return rightSon;
    }

    public void setRightSon(BinaryTreeNode rightSon) {
        this.rightSon = rightSon;
    }


}
