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

    public static void mergeSort(int[] arr) {

    }

    public static void quickSort(int[] arr) {

    }

    public static void heapSort(int[] arr) {

    }
}
