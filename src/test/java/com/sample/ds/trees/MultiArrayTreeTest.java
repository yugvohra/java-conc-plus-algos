package com.sample.ds.trees;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class MultiArrayTreeTest {
    @Test
    public void shouldFindSubTreeWithMaxAvg() {
        MultiArrayTree.Node leafNode_1 = new MultiArrayTree.Node(1, new HashSet<>(), Integer.MIN_VALUE);
        MultiArrayTree.Node leafNode_2 = new MultiArrayTree.Node(2, new HashSet<>(), Integer.MIN_VALUE);
        MultiArrayTree.Node leafNode__4 = new MultiArrayTree.Node(4, new HashSet<>(), Integer.MIN_VALUE);
        MultiArrayTree.Node leafNode__minus_2 = new MultiArrayTree.Node(-2, new HashSet<>(), Integer.MIN_VALUE);
        MultiArrayTree.Node innernode_minus_5 = new MultiArrayTree.Node(-5, Set.of(leafNode_1, leafNode_2), Integer.MIN_VALUE);
        MultiArrayTree.Node innernode_13 = new MultiArrayTree.Node(13, Set.of(leafNode__4, leafNode__minus_2), Integer.MIN_VALUE);
        MultiArrayTree.Node innernode_4 = new MultiArrayTree.Node(4, new HashSet<>(), Integer.MIN_VALUE);
        MultiArrayTree.Node root = new MultiArrayTree.Node(4, Set.of(innernode_minus_5, innernode_13, innernode_4), Integer.MIN_VALUE);

        MultiArrayTree multiArrayTree = new MultiArrayTree();
        assertThat(multiArrayTree.findSubTreeWithMaxAverage(root)).isEqualTo(innernode_13);
    }

    @Test
    public void shouldFindSubTreeWithMaxAvg_of_1_level_tree() {
        MultiArrayTree.Node leafNode_21 = new MultiArrayTree.Node(21, new HashSet<>(), Integer.MIN_VALUE);
        MultiArrayTree.Node leafNode_5 = new MultiArrayTree.Node(5, new HashSet<>(), Integer.MIN_VALUE);
        MultiArrayTree.Node leafNode_minus_1 = new MultiArrayTree.Node(-1, new HashSet<>(), Integer.MIN_VALUE);
        MultiArrayTree.Node leaf_node_minus_5 = new MultiArrayTree.Node(-5, new HashSet<>(), Integer.MIN_VALUE);
        MultiArrayTree.Node root = new MultiArrayTree.Node(1, Set.of(leafNode_21, leafNode_5, leafNode_minus_1, leaf_node_minus_5), Integer.MIN_VALUE);

        MultiArrayTree multiArrayTree = new MultiArrayTree();
        assertThat(multiArrayTree.findSubTreeWithMaxAverage(root)).isEqualTo(leafNode_21);
    }

}