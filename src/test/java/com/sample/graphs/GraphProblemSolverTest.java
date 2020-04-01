package com.sample.graphs;

import com.sample.ds.graphs.GraphProblemSolver;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GraphProblemSolverTest {

    @Test
    void findMotherNode() {
        int[][]Graph = {{0,1,1,0,0,0,0},{0,0,0,1,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,1,0,0,1},{0,0,0,1,0,0}};
        GraphProblemSolver graphProblemSolver =new GraphProblemSolver();
        assertThat(graphProblemSolver.findMotherNode(Graph)).isEqualTo(5);

    }
    @Test
    void findBridges() {
        int[][]Graph = {{0,1,1,0,0,0,0,0,0},{1,0,1,0,0,0,0,0,0},{1,1,0,1,0,1,0,0,0},{0,0,1,0,1,0,0,0,0},{0,0,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,1,0,1},{0,0,0,0,0,1,0,1,0},{0,0,0,0,0,0,1,0,1},{0,0,0,0,0,1,0,1,0}};
        GraphProblemSolver graphProblemSolver =new GraphProblemSolver();
        System.out.println(graphProblemSolver.findBridges(Graph));

    }
}