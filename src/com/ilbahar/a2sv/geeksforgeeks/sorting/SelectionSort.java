package com.ilbahar.a2sv.geeksforgeeks.sorting;

public class SelectionSort {

    int  select(int[] arr, int i)
    {
        // code here such that selectionSort() sorts arr[]
        int minIndex = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[minIndex] > arr[j]) {
                minIndex = j;
            }
        }
        return minIndex;
    }

    void selectionSort(int[] arr, int n)
    {
        //code here
        for (int i = 0; i < n - 1; i++) {
            int minIndex = select(arr, i);
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

}
