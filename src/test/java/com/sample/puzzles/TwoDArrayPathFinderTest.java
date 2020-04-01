package com.sample.puzzles;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TwoDArrayPathFinderTest {

    @Test
    public void shouldReturnAllPaths() {
        int[][] array = {{7, 5, 3}, {2, 0, 9}, {4, 5, 9}};
        TwoDArrayPathFinder pathFinder = new TwoDArrayPathFinder();
        System.out.println(pathFinder.findAllPaths(array));
    }

    @Test
    public void shoulddReturnMaxValues_Of_minimum_of_AllPAths() {
        int[][] array = {{7, 5, 3}, {2, 0, 9}, {4, 5, 9}};
        TwoDArrayPathFinder pathFinder = new TwoDArrayPathFinder();

        assertThat(pathFinder.findMaxOfMinValuesInPaths(pathFinder.findAllPaths(array))).isEqualTo(3);

    }
}