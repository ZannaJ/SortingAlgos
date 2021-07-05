package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // [4, 2, 8, 3, 9]
        // Arrays.sort()


        // Bubble sort

        int[] numbers = {4, 2, 8, 5, 3, 9};

//        for (int i = 0; i < numbers.length; i++) {
//            for (int j = 0; j < numbers.length - 1 - i; j++) {
//                if (numbers[j] > numbers[j + 1]) {
//                    // Create a temporary variable  to hold the current value
//                    // at index j
//                    int temp = numbers[j];
//
//                    // swap the numbers together
//                    numbers[j] = numbers[j + 1];
//                    numbers[j + 1] = temp;
//                }
//            }
//        }

//        System.out.println(Arrays.toString(numbers));


        // Insertion sort
        // This algorithm sort by comparing the values at the indexes with the previous elements to sort the elements.
        // We place the value at the index where there are no lesser values to the elements.

//        for (int i = 1; i < numbers.length; i++) {
//            int valueToSort = numbers[i];
//            int j;
//            for (j = i; j > 0 && numbers[j - 1] > valueToSort; j--) {
//                numbers[j] = numbers[j - 1];
//            }
//
//            numbers[j] = valueToSort;
//
//        }

//        System.out.println(Arrays.toString(numbers));


        // Selection Sort
        // Find the minimum element in the array
        // Swap that minimum element with the current element
        // Repeat the whole process until the array is fully sorted.

//        for (int i = 0; i < numbers.length - 1; i++) {
//            int index = i; // current index of the number
//            for (int j = i + 1; j < numbers.length; j++) {
//                if (numbers[j] < numbers[index]) {
//                    index = j; // swap if number at position j less than number at position index
//                }
//            }
//            int smallerNumber = numbers[index];
//            numbers[index] = numbers[i];
//            numbers[i] = smallerNumber;
//        }
//        System.out.println(Arrays.toString(numbers));


//        mergeSort(0, numbers.length - 1, numbers);
//        System.out.println(Arrays.toString(numbers));

        int[] values = {3, 8, 3, 5, 9};
        mergeSort(0, values.length - 1, values); // Call the mergeSort method to sort the array
        System.out.println(Arrays.toString(values)); // Output the sorted array to the console

    }

    public static void mergeSort(int start, int end, int[] numbers) {
        // Merge Sort
        // Divide the array into subarrays of about half size in each iteration/repetition
        // until each subarray has only one element
        // Merge each subarray repeatedly to create sorted arrays. This is going to repeat
        // itself until we have only one sorted array. This is the sorted array

        // Recursive method
        int mid = (start + end) / 2;

        if (start < end) {
            // sort left half
            mergeSort(start, mid, numbers);

            // sort right half
            mergeSort(mid + 1, end, numbers);

            // merge
            merge(start, mid, end, numbers);
        }
    }

    public static void merge(int start, int mid, int end, int[] numbers) {
        // Initialize the temp Array and index
        int[] tempArray = new int[numbers.length]; // Create a temporary array
        int tmpArrayIndex = start; // create a temporary index

        // initialize start index and mid index to be used as counters
        int startIndex = start;
        int midIndex = mid + 1;

        // Iterate until the smaller array reaches the end.
        while (startIndex <= mid && midIndex <= end) {
            if (numbers[startIndex] < numbers[midIndex]) {
                // The ++ increases the value by one after it has been used
                // to prevent the while loop from giving us an infinite loop
                tempArray[tmpArrayIndex++] = numbers[startIndex++];
            } else {
                tempArray[tmpArrayIndex++] = numbers[midIndex++];
            }
        }

        // copy the remaining elements into the array
        while(startIndex <= mid) {
            tempArray[tmpArrayIndex++] = numbers[startIndex++];
        }

        while (midIndex <= end) {
            tempArray[tmpArrayIndex++] = numbers[midIndex++];
        }

        // copy our temporary array to the actual array after sorting
        if (end + 1 - start >= 0) {

            // java method for copying arrays
            System.arraycopy(tempArray, start, numbers, start, end + 1 - start);
        }
    }

}