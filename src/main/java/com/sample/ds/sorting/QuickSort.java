package com.sample.ds.sorting;

public class QuickSort {

    public static void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int begin, int end) {
        if (begin < end) {
            int partition = partition_and_return_pivot(array, begin, end);
            quickSort(array, begin, partition - 1);
            quickSort(array, partition + 1, end);
        }
    }

    private static int partition_and_return_pivot(int[] array, int begin, int end) {
        int pivot = array[end];
        int leftIdx = begin - 1;
        for (int idx = begin; idx < end; idx++) {
            if (array[idx] <= pivot) {
                //add it into the left array
                int swap = array[idx];
                array[idx] = array[++leftIdx];
                array[leftIdx] = swap;
            }
        }
        // put the pivot in correct position
        int swap = array[++leftIdx];
        array[leftIdx] = pivot;
        array[end] = swap;
        return leftIdx;
    }

}
