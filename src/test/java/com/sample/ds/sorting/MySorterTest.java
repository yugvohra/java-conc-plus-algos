package com.sample.ds.sorting;

import com.sample.ds.sorting.MySorter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MySorterTest {

    @Test
    public void shouldSortUsingSelectionSort() {
        int[] subjectArray = {1, 5, 4, 6, 78, 23, 43};
        MySorter sorter = new MySorter();
        sorter.selectionSort(subjectArray);
        assertThat(subjectArray).isEqualTo(new int[]{1, 4, 5, 6, 23, 43, 78});
    }

    @Test
    public void shouldSortUsingQuickSort() {
        int[] subjectArray = {1, 5, 4, 6, 78, 23, 43};
        MySorter sorter = new MySorter();
        sorter.quickSort(subjectArray);
        assertThat(subjectArray).isEqualTo(new int[]{1, 4, 5, 6, 23, 43, 78});
    }

}