package com.sample.ds.trees;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BreadthFirstTreeTraversalTest {

    @Test
    public void should_calculate_correct_heigh_of_given_tree() {
        //Arrange
        BinaryTreeNode<String> leftLevel2Leave = new BinaryTreeNode<>("leaf@2", null, null);
        BinaryTreeNode<String> rightLevel2Leave = new BinaryTreeNode<>("leaf@2", null, null);
        BinaryTreeNode<String> leftLevel1Node = new BinaryTreeNode<>("node@1", leftLevel2Leave, rightLevel2Leave);
        BinaryTreeNode<String> rightLevel1Node = new BinaryTreeNode<>("node@1", null, null);
        BinaryTreeNode<String> root = new BinaryTreeNode<>("root", leftLevel1Node, rightLevel1Node);

        BreadthFirstTreeTraversal<String> breadthFirstTreeTraversal = new BreadthFirstTreeTraversal<>();

        //Act
        int height = breadthFirstTreeTraversal.getHeightOfTree(root);

        //Assert

        assertThat(height).isEqualTo(3);
    }

    @Test
    public void should_print_tree_in_BF() {
        //Arrange
        BinaryTreeNode<String> leftLevel2Leave = new BinaryTreeNode<>("leaf@2", null, null);
        BinaryTreeNode<String> rightLevel2Leave = new BinaryTreeNode<>("leaf@2", null, null);
        BinaryTreeNode<String> leftLevel1Node = new BinaryTreeNode<>("node@1", leftLevel2Leave, rightLevel2Leave);
        BinaryTreeNode<String> rightLevel1Node = new BinaryTreeNode<>("node@1", null, null);
        BinaryTreeNode<String> root = new BinaryTreeNode<>("root", leftLevel1Node, rightLevel1Node);

        BreadthFirstTreeTraversal<String> breadthFirstTreeTraversal = new BreadthFirstTreeTraversal<>();

        //Act
        breadthFirstTreeTraversal.traverseRecursively(root);
    }

    @Test
    public void when_TraverseIteratively_should_print_tree() {
        //Arrange
        BinaryTreeNode<String> leftLevel2Leave = new BinaryTreeNode<>("leaf@2", null, null);
        BinaryTreeNode<String> rightLevel2Leave = new BinaryTreeNode<>("leaf@2", null, null);
        BinaryTreeNode<String> leftLevel1Node = new BinaryTreeNode<>("node@1", leftLevel2Leave, rightLevel2Leave);
        BinaryTreeNode<String> rightLevel1Node = new BinaryTreeNode<>("node@1", null, null);
        BinaryTreeNode<String> root = new BinaryTreeNode<>("root", leftLevel1Node, rightLevel1Node);

        BreadthFirstTreeTraversal<String> breadthFirstTreeTraversal = new BreadthFirstTreeTraversal<>();

        //Act
        breadthFirstTreeTraversal.traverseIteratively(root);
    }
}