package com.sample.concurrent;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SimpleForkJoinExecutor {
    public static void main(String[] args) {
        int[] array = {11,12,43,7,88,9,0,4,5,45,22,12,54,56,12};
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        System.out.println(pool.invoke(new FindMin(array)));
    }

    static class FindMin extends RecursiveTask<Integer>{

        private final int[] subjArray;

        FindMin(int[] subjArray) {
            this.subjArray = subjArray;
        }

        @Override
        protected Integer compute() {
            if(subjArray.length>2)
            {
                FindMin leftMin = new FindMin(Arrays.copyOfRange(subjArray,0,subjArray.length/2));
                FindMin rightMin = new FindMin(Arrays.copyOfRange(subjArray,subjArray.length/2,subjArray.length));
                leftMin.fork();
                rightMin.fork();
                return Math.min(leftMin.join(),rightMin.join());
            }else{
                return Math.min(subjArray[0],subjArray[subjArray.length-1]);
            }
        }
    }
}
