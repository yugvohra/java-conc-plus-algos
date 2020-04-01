package com.sample.ds.trees;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;

public class MultiArrayTree {


    /**
     * Given a m-array tree
     * find the subtree with maximum average
     * @param root
     * @return
     */
    public Node findSubTreeWithMaxAverage(Node root){
        LinkedList<Node>queue = new LinkedList<>();
        Set<Node>visitedNode = new HashSet<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node currentNode= queue.getLast();
            if(currentNode.getChildren().size()==0&&currentNode.getAvgValueOfThisTree()==0){
                currentNode.setAvgValueOfThisTree(currentNode.getValue());
                visitedNode.add(queue.removeLast());
            }else if(visitedNode.containsAll(currentNode.getChildren())){
                int sum = 0;
                int value = currentNode.getValue();
                for(Node node : currentNode.getChildren()){
                    sum+=node.getValue();
                }
                currentNode.setAvgValueOfThisTree((sum+value)/(currentNode.getChildren().size()+1));
                visitedNode.add(queue.removeLast());
            }else {
                queue.addAll(currentNode.getChildren());
            }
        }
        return nodeWithMaximumValue(visitedNode);
    }

    /**
     * return the subtree with maximum value
     * @param visitedNode
     * @return
     */
    private Node nodeWithMaximumValue(Set<Node> visitedNode) {
        int maxValue=Integer.MIN_VALUE;
        Node maxNode = null;
        for(Node node:visitedNode){
            if(node.getAvgValueOfThisTree()>maxValue){
                maxValue=node.getAvgValueOfThisTree();
                maxNode = node;
            }
        }
        return maxNode;
    }

    public static class Node{
        final int value;
        final Set<Node> children;
        int avgValueOfThisTree;

        public Node(int value, Set<Node> children, int avgValueOfThisTree) {
            this.value = value;
            this.children = children;
            this.avgValueOfThisTree = avgValueOfThisTree;
        }

        public int getValue() {
            return value;
        }

        public Set<Node> getChildren() {
            return children;
        }

        public int getAvgValueOfThisTree() {
            return avgValueOfThisTree;
        }

        public void setAvgValueOfThisTree(int avgValueOfThisTree) {
            this.avgValueOfThisTree = avgValueOfThisTree;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return getValue() == node.getValue() &&
                    Objects.equals(getChildren(), node.getChildren());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getValue(), getChildren());
        }
    }

}
