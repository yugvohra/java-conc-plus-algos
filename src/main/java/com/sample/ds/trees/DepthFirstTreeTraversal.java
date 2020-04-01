
package com.sample.ds.trees;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Traverse the tree in DF fashion
 *
 * @param <T>
 */
public class DepthFirstTreeTraversal<T> {
    /**
     * Traverse and print the node recursively
     * @param root
     */
    public void traverseRecursively(BinaryTreeNode<T> root) {
        if (root == null)
            return;
        System.out.println(root.getInfo());
        traverseRecursively(root.getLeftSon());
        traverseRecursively(root.getRightSon());
    }

    /**
     * traverse the tree iteratively
     * use LIFO as an auxiliary data structure
     * @param root
     */
    public void traverseIteratively(BinaryTreeNode<T> root) {
        LinkedList<BinaryTreeNode<T>> auxQueue = new LinkedList();
        auxQueue.add(root);
        while (!auxQueue.isEmpty()) {
            BinaryTreeNode<T> node = auxQueue.removeLast();
            if (node != null) {
                System.out.println(node.getInfo().toString());
                auxQueue.add(node.getRightSon());
                auxQueue.add(node.getLeftSon());
            }
        }
    }
}
