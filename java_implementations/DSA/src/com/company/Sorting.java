package com.company;
import java.util.Random;

public class Sorting {

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

            if(!swapped){
                break;
            }
        }
    }

    public static void randomizeArray(int[] arr) {
        Random rand = new Random();
        for(int i=0;i < arr.length;i++) {
            int index = rand.nextInt(arr.length-i);
            int temp = arr[arr.length-1-i];
            arr[arr.length-1-i] = arr[index];
            arr[index] = temp;
        }
    }

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

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            // change key < to key > to sort in descending order
            while (j >= 0 && key < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = key;
        }
    }

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

    public static void quickSort(int[] arr) {

    }

    public static void heapSort(int[] arr) {

    }
}