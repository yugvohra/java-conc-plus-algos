package com.sample.ds.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    public void whenGivenAnArray_should_quick_sort(){
        //Arrange
        int array[] = {23,12,34,56,3,4,78,67};

        //Act
        QuickSort.sort(array);

        //Assert
        assertThat(array).isSorted();
    }

}