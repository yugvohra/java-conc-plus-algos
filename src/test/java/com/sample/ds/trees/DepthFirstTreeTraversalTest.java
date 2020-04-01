package com.sample.ds.trees;

import org.junit.jupiter.api.Test;

class DepthFirstTreeTraversalTest {

    @Test
    public void whenGivenARoot_shouldTraverseTree() {
        //Arrange
        BinaryTreeNode<String> leftLevel2Leave = new BinaryTreeNode<>("leaf@2", null, null);
        BinaryTreeNode<String> rightLevel2Leave = new BinaryTreeNode<>("leaf@2", null, null);
        BinaryTreeNode<String> leftLevel1Node = new BinaryTreeNode<>("node@1", leftLevel2Leave, rightLevel2Leave);
        BinaryTreeNode<String> rightLevel1Node = new BinaryTreeNode<>("node@1", null, null);
        BinaryTreeNode<String> root = new BinaryTreeNode<>("root", leftLevel1Node, rightLevel1Node);

        //Act
        DepthFirstTreeTraversal<String> depthFirstTreeTraversal = new DepthFirstTreeTraversal<>();
        depthFirstTreeTraversal.traverseIteratively(root);
    }

}