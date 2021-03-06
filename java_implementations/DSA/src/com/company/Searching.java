package com.company;

/*
    find element in a structure
 */
public class Searching {

    /* Linear Search
   Linear search algorithm is used when
       - searching operations in smaller arrays, less than 100 items
   Time Complexity: O(n)
   Space Complexity: O(1)
    */
    public static int linearSearch(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    /* Binary Search
   Binary search algorithm is used when
       - debugging, its used to pinpoint the place an error happens
   Time Complexity:
       Best: O(1)
       Worst: O(logn)
       Average: O(logn)
       Space Complexity: O(1)
    */
    public static int binarySearch(int[] arr, int low, int high, int x) {
        if( high >= low) {
            int mid = low + (high - low) / 2;

            if (arr[mid]== x) {
                return mid;
            }
            // search left half
            if (arr[mid] > x) {
                return binarySearch(arr, low, mid-1, x);
            }

            return binarySearch(arr, mid + 1, high, x);
        }

        return -1;
    }
}
