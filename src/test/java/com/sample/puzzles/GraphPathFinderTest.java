package com.sample.puzzles;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class GraphPathFinderTest {
    @Test
    public void shouldFindAllPaths() {
        //Arrange
        int[][] graph = {{0, 1, 1, 1}, {0, 0, 0, 1}, {1, 1, 0, 0}, {0, 0, 0, 0}};
        GraphPathFinder pathFinder = new GraphPathFinder();
        int[][] expectedPaths = {{2,0,3},{2,1,3},{2,0,1,3}};
        //Act
        Set<Set<Integer>> paths = pathFinder.findAllPaths(graph, 2, 3);
        //Assert
        assertThat(paths.size()).isEqualTo(3);
        assertThat((paths)).isEqualTo(paths);
    }

}