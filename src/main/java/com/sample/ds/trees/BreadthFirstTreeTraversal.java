
package com.sample.ds.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BF traversal of Binary tree
 * @param <T>
 */
public class BreadthFirstTreeTraversal<T> {

    /**
     * Recursive algorithm to print tree in BF mode
     *
     * @param root
     */
    public void traverseRecursively(BinaryTreeNode<T> root) {
        int height = getHeightOfTree(root);
        for (int i = 1; i <= height; i++) {
            printGivenLevel(root, i);
        }
    }

    /**
     * Print binary tree in BF mode
     * uses queue as an auxiliary data structure
     * @param root
     */
    public void traverseIteratively(BinaryTreeNode<T> root) {
        Queue<BinaryTreeNode<T>> auxQueue = new LinkedList();
        auxQueue.add(root);
        while (!auxQueue.isEmpty()) {
            BinaryTreeNode<T> node = auxQueue.poll();
            if (node != null) {
                System.out.println(node.getInfo().toString());
                auxQueue.add(node.getLeftSon());
                auxQueue.add(node.getRightSon());
            }
        }
    }

    /**
     * Recursively prints a level of the binary tree
     * @param root
     * @param i
     */
    private void printGivenLevel(BinaryTreeNode<T> root, int i) {
        if (root == null)
            return;
        if (i == 1)
            System.out.println(root.getInfo());
        printGivenLevel(root.getLeftSon(), i - 1);
        printGivenLevel(root.getRightSon(), i - 1);
    }

    /**
     * finds the height of the tree
     * @param root
     * @return
     */
    public int getHeightOfTree(BinaryTreeNode<T> root) {
        return findHeightOfTreeRecursively(root);
    }

    /**
     * Recursively finds the height of the tree
     * leaves returns the height of 1 and then this is propagated upwards during backtracking
     * @param root
     * @return
     */
    public int findHeightOfTreeRecursively(BinaryTreeNode<T> root) {
        if (root == null)
            return 0;
        BinaryTreeNode<T> leftTree = root.getLeftSon();
        BinaryTreeNode<T> rightTree = root.getRightSon();
        int leftHight = findHeightOfTreeRecursively(leftTree);
        int rightHight = findHeightOfTreeRecursively(rightTree);
        if (leftHight > rightHight)
            return leftHight + 1;
        return rightHight + 1;

    }
}
