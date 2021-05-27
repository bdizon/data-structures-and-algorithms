package com.company;

import java.util.Arrays;

public class SearchingMain {
    public static void main(String[] args) {
        int[] arr = {6,1,3,8,9,4,5};
        System.out.println("Unsorted array: "  + Arrays.toString(arr));

        Sorting.quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));

        int x = 8;
        int result = Searching.linearSearch(arr, x);
        System.out.println("Using linear search to look for: " + x);
        if (result == -1)
            System.out.println("Not found");
        else
            System.out.println("Element found at index " + result);

        int y = 1;
        int result2 = Searching.binarySearch(arr, 0, arr.length - 1, y);
        System.out.println("Using binary search to look for: " + y);
        if (result2 == -1)
            System.out.println("Not found");
        else
            System.out.println("Element found at index " + result2);
    }
}
