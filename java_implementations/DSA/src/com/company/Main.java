package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] arr = {6,1,3,8,9,4,5};
        System.out.println("Unsorted array: "  + Arrays.toString(arr));
//        Sorting sort = new Sorting();

//        Sorting.bubbleSort(arr);
//        Sorting.selectionSort(arr);
        Sorting.insertionSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        Sorting.randomizeArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
