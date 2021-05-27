package com.company;
import java.util.Random;

/*
    sort values in a structure
 */
public class Sorting {

    /*
    Randomize array
     */
    public static void randomizeArray(int[] arr) {
        Random rand = new Random();
        for(int i=0;i < arr.length;i++) {
            int index = rand.nextInt(arr.length-i);
            int temp = arr[arr.length-1-i];
            arr[arr.length-1-i] = arr[index];
            arr[index] = temp;
        }
    }

    /* Bubble Sort
    Bubble sort is used if
        - complexity does not matter
        - short and simple code is preferred
    Time Complexity:
        Best: O(n)
        Worst: O(n^2)
        Average: O(n^2)
        Space Complexity: O(1)
     */
    public static void bubbleSort(int[] arr) {
        for(int i=0;i < arr.length-1; i++) {
            boolean swapped = false;

            for(int j=0; j < arr.length-i-1; j++) {
                // change > to < to sort in descending
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            // no swaps were made so everything is in its place
            if(!swapped){
                break;
            }
        }
    }

    /* Selection Sort
    The selection sort is used when
        - a small list is to be sorted
        - cost of swapping does not matter
        - checking of all the elements is compulsory
        - cost of writing to a memory matters like in flash memory (number of writes/swaps is O(n) as compared to O(n2) of bubble sort)
    Time Complexity:
        Best: O(n^2)
        Worst: O(n^2)
        Average: O(n^2)
        Space Complexity: O(1)
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;

            for (int j = i+1; j < arr.length; j++) {
                // change < to > to sort in descending order
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    /* Insertion Sort
    The insertion sort is used when:
        - the array is has a small number of elements
        - there are only a few elements left to be sorted
    Time Complexity:
        Best: O(n)
        Worst: O(n^2)
        Average: O(n^2)
        Space Complexity: O(1)
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            // use to look back
            int j = i - 1;
            // change key < to key > to sort in descending order
            while (j >= 0 && key < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = key;
        }
    }

    /* Merge Sort
    The merge sort is used when
        - Inversion count problem
        - External sorting
        - E-commerce applications
    Time Complexity:
        Best: O(nlogn)
        Worst: O(nlogn)
        Average: O(nlogn)
        Space Complexity: O(n)
     */
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m  = (l + r) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);

            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int p, int q, int r) {
        int n1 = q-p+1;
        int n2 = r-q;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[p+i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[q+1+j];
        }

        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }

    /* Quick Sort
    Quicksort algorithm is used when
        - the programming language is good for recursion
        - time complexity matters
        - space complexity matters
    Time Complexity:
        Best: O(nlogn)
        Worst: O(n^2), pivot element is either greatest or smallest
        Average: O(nlogn)
        Space Complexity: O(logn)
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // partition array and find pivot first
            int pivot = partition(arr, low, high);

            // recursively call on the left and right of pivot
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // rightmost element as pivot
        int pivot = arr[high];
        // 1st pointer for greater element you need to switch with
        // need this subtract one to make sure for the the case
        // low = 0, high = 1 we won't go over the the index value
        int i = low - 1;

        // look through elements and compare
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                // if element is smaller than pivot
                // then swap with greater element pointed by i
                // keeps track of element greater than pivot element
                i++;

                //swap element at with element at j
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap the pivot element with the greater element
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // return the position where partition was done
        return (i + 1);
    }

    /* Heap Sort
   Heapsort algorithm is used when
       - space complexity is low
       - priority queue implementation: want to extract smallest (or largest) from list of items without keeping remaining in sorted order
   Time Complexity:
       Best: O(nlogn)
       Worst: O(nlogn)
       Average: O(nlogn)
       Space Complexity: O(1)
    */
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // building max heap from bottom up
        // n/2-1 get first index of non-leaf node
        for (int i = n/2-1; i>= 0; i--) {
            heapify(arr, n, i);
        }

        // start heap sort
        for (int i = n-1; i >= 0; i--) {
            // largest will be in first element
            // swap largest to the place in the right most place it belongs
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // heapify root element
            heapify(arr, i, 0);
        }

    }

    private static void heapify(int[] arr, int n, int i){
        // find largest among root, left child, and right child
        int largest = i;
        int l = 2 * i + i;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest]){
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]){
            largest = r;
        }

        // swap and heapify if largest/(root) is not largest
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
}