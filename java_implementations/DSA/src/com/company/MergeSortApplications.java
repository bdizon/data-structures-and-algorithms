package com.company;

/* Applications of Merge Sort
    - Inversion count problem: implemented
    - External sorting:
        External sorting is a term for a class of sorting algorithms that can handle massive amounts of data.
        External sorting is required when the data being sorted do not fit into the main memory of a computing
        device (usually RAM) and instead, they must reside in the slower external memory (usually a hard drive).
        External sorting typically uses a hybrid sort-merge strategy. In the sorting phase, chunks of data small
        enough to fit in main memory are read, sorted, and written out to a temporary file. In the merge phase,
        the sorted sub-files are combined into a single larger file.
    - E-commerce applications:
        Have you ever noticed on any e-commerce website, they have this section of "You might like", they have
        maintained an array for all the user accounts and then whichever has the least number of inversion with
        your array of choices, they start recommending what they have bought or they like. I am not going into the
        time and space complexity details of the algorithm. Obviously there are a lot of ways of doing this and this
        is one of them.
*/

public class MergeSortApplications {

    /* Count Inversions in an array using Merge Sort (difficulty - hard)

    Inversion Count for an array indicates – how far (or close) the array is from being sorted.
    If the array is already sorted, then the inversion count is 0, but if the array is sorted in the
    reverse order, the inversion count is the maximum.
    Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j

    How to use this concept:
    Suppose you have a list of 10 things and you have two friends and you ask both the friends to order the things in descending order of their liking.
    You will have two arrays after that, now you count the number of inversion they have and more the number of inversion, the more dissimilar there
    choices are, less the number of inversions the more similar their choices are.
     */
    private static int mergeCount(int[] arr, int p, int q, int r) {
        int swaps = 0;
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
                // count swaps ranging from mid to the remaining elements in the left sub-array bc the smallest value in the right sub-array is still smallest thab whats at the left
                swaps += (q+1)-(p+i);
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
        }

        return swaps;
    }

    private static int mergeSortCount(int[] arr, int l, int r) {
        int count = 0;
        if (l < r) {
            int m = (l+r) / 2;
            count += mergeSortCount(arr, l, m);
            count += mergeSortCount(arr, m+1, r);
            count += mergeCount(arr, l, m, r);

        }

        return count;
    }




    public static void main(String[] args) {
        int[] arr = { 1, 20, 6, 4, 5 };

        System.out.println("Number of inversions: " + mergeSortCount(arr, 0, arr.length - 1));
    }
}
