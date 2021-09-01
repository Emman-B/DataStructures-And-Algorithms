package com.github.emman_b;

public class MergeSort {
    public static void sort(Comparable[] data) {
        // ignore data arrays of length 1 or 0
        if (data.length < 2) return;

        // get the middle of the array
        int middle = data.length / 2;

        mergeSort(data, 0, data.length - 1);
    }

    private static void mergeSort(Comparable[] data, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(data, start, middle);
            mergeSort(data, middle + 1, end);
            merge(data, start, end);
        }
    }

    private static void merge(Comparable[] data, int start, int end) {
        int middle = (start + end) / 2;
        // indicate the indices for the merge
        int left = start;
        int leftEnd = middle;
        int right = middle + 1;
        int rightEnd = end;

        // create new data copies as left and right halves to reference when merging
        Comparable[] leftHalf = new Comparable[leftEnd - left + 1];
        Comparable[] rightHalf = new Comparable[rightEnd - right + 1];
        // redefine the indices to correlate with the new data half copies
        left = 0;
        right = 0;
        leftEnd = leftHalf.length - 1;
        rightEnd = rightHalf.length - 1;
        // copy into left half
        for (int i = left; i <= leftEnd; ++i) {
            leftHalf[i] = data[start + i];
        }
        // copy into right half
        for (int i = right; i <= rightEnd; ++i) {
            rightHalf[i] = data[middle + 1 + i];
        }


        // create index for data
        int dataIndex = start;

        // loop while inserting into the data array
        while (left <= leftEnd && right <= rightEnd) {
            if (leftHalf[left].compareTo(rightHalf[right]) < 0) {
                data[dataIndex++] = leftHalf[left++];
            } else {
                data[dataIndex++] = rightHalf[right++];
            }
        }

        // at this point, either the left or right indices have exceeded corresponding the end index, so we need to copy
        //      the unfinished half into the array

        // copy left half if unfinished
        for (; left <= leftEnd; ++left) {
            data[dataIndex++] = leftHalf[left];
        }

        // copy right half if unfinished
        for(; right <= rightEnd; ++right) {
            data[dataIndex++] = rightHalf[right];
        }
    }
}
