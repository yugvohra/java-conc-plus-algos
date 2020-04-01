package com.sample.ds.sorting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Implementation of few sorting algorithms
 */
public class MySorter {

    /**
     * Selection sort
     * @param array
     */
    public void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minimum = Integer.MAX_VALUE;
            int minimumIdx = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < minimum) {
                    minimumIdx = j;
                    minimum = array[j];
                }
            }
            swapElements(array, i, minimumIdx);
        }
    }

    private void swapElements(int[] array, int i, int minimumIdx) {
        int swap = array[i];
        array[i] = array[minimumIdx];
        array[minimumIdx] = swap;
    }

    /**
     * Quick sort
     * @param array
     */
    public void quickSort(int array[]) {
        sortQuick(array, 0, array.length - 1);
    }

    private void sortQuick(int[] array, int i, int length) {
        if (i < length) {
            int partion = partition(array, i, length);
            sortQuick(array, i, partion - 1);
            sortQuick(array, partion + 1, length);
        }
    }

    private int partition(int[] array, int low, int high) {
        int partition = array[low];
        int i = low;
        int j = low + 1;
        while (j <= high) {
            if (array[j] <= partition) {
                swapElements(array, i, j);
                i++;
            }
            j++;
        }
        array[i] = partition;
        return i;
    }
}
