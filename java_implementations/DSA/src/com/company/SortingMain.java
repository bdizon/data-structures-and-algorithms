package com.company;

import java.util.Arrays;

public class SortingMain {

    public static void main(String[] args) {

        int[] arr = {6,1,3,8,9,4,5};
        System.out.println("Unsorted array: "  + Arrays.toString(arr));
//        Sorting sort = new Sorting();

//        Sorting.bubbleSort(arr);
//        Sorting.selectionSort(arr);
//        Sorting.insertionSort(arr);
//        Sorting.mergeSort(arr, 0, arr.length - 1);
//        Sorting.quickSort(arr, 0, arr.length - 1);
        Sorting.heapSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        Sorting.randomizeArray(arr);
        System.out.println("Unsorted array: "  + Arrays.toString(arr));

    }


}
